using NLog;
using System;
using System.Drawing;
using System.Windows.Forms;

namespace Laba2
{
    public partial class Form1 : Form
    {

        Depo depo;

        FormSelectLoc form;

        private Logger log;


        public Form1()
        {
            InitializeComponent();
            log = LogManager.GetCurrentClassLogger();
            depo = new Depo(5);
            for (int i = 0; i < 6; ++i)
            {
                listBoxLevels.Items.Add("Level " + i);
            }
            listBoxLevels.SelectedIndex = depo.CurrentLevel;
            Draw();
        }

        private void Draw()
        {
            if (listBoxLevels.SelectedIndex > -1)
            {
                Bitmap bmp = new Bitmap(pictureBoxDraw.Width, pictureBoxDraw.Height);
                Graphics gr = Graphics.FromImage(bmp);
                depo.Draw(gr);
                pictureBoxDraw.Image = bmp;
            }
        }


        private void Form1_Load(object sender, EventArgs e)
        {


        }

        private void buttonLvlDown_Click(object sender, EventArgs e)
        {
            depo.LevelDown();
            listBoxLevels.SelectedIndex = depo.CurrentLevel;
            Draw();
            log.Info("Переход на уровень ниже. Текущий уровень: " + depo.CurrentLevel);
        }

        private void buttonLvlUp_Click(object sender, EventArgs e)
        {
            depo.LevelUp();
            listBoxLevels.SelectedIndex = depo.CurrentLevel;
            Draw();
            log.Info("Переход на уровень выше. Текущий уровень: " + depo.CurrentLevel);
        }

        private void buttonGet_Click(object sender, EventArgs e)
        {
            if (listBoxLevels.SelectedIndex > -1)
            {
                if (maskedTextBox1.Text != "")
                {
                    try
                    {
                        var loc = depo.GetLocIntDepo(Convert.ToInt32(maskedTextBox1.Text));
                        loc.setPosition(pictureBox1.Width >> 1, pictureBox1.Height >> 1);
                        Bitmap main = new Bitmap(pictureBox1.Width, pictureBox1.Height);
                        Graphics g = Graphics.FromImage(main);
                        Rotate.rotate(g, loc.Pict, 0, loc.Center);
                        pictureBox1.Image = main;
                        Draw();
                        log.Info("Выдан локомотив класса " + loc.GetType().Name + " С Уровеня " + depo.CurrentLevel + ", места " + Convert.ToInt32(maskedTextBox1.Text));
                    }
                    catch (DepoIndexOutOfRangeException ex)
                    {
                        MessageBox.Show(ex.Message, "out of range exception", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                    catch (Exception ex)
                    {
                        MessageBox.Show(ex.Message, "Common exception", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                }
            }
        }

        private void listBoxLevels_SelectedIndexChanged(object sender, EventArgs e)
        {
            depo.CurrentLevel = listBoxLevels.SelectedIndex;
            Draw();
            log.Info("Переход на другой уровень. Текущий уровень: " + depo.CurrentLevel);
        }

        private void buttonOrder_Click(object sender, EventArgs e)
        {
            form = new FormSelectLoc(log);
            form.AddEvent(addLoc);
            form.Show();
            log.Info("Открытие окна создания локомотива");
        }

        private void addLoc(ITransport shit)
        {
            if (shit != null)
            {
                try
                {
                    int place = depo.PutLocInDepo(shit);
                    Draw();
                    MessageBox.Show("Ваше место: " + place);
                    log.Info("Добавлен новый объект класса " + shit.GetType().Name + ". Уровень " + depo.CurrentLevel + ", место " + place);
                }
                catch (DepoOverflowException ex)
                {
                    MessageBox.Show(ex.Message, "Overflow exception", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message, "Common exception", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }

            }
        }

        private void saveToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (saveFileDialog1.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            {
                if (depo.SaveData(saveFileDialog1.FileName))
                {
                    MessageBox.Show("save successfully", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    log.Info("Запись в файл " + saveFileDialog1.FileName);
                }
            }
            else
            {
                MessageBox.Show("preservation failed", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                log.Info("Провалена запись в файл " + saveFileDialog1.FileName);
            }
        }

        private void downloadToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (openFileDialog1.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            {
                if (depo.LoadData(openFileDialog1.FileName))
                {
                    MessageBox.Show("downloaded", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    log.Info("Загрузка из файла " + openFileDialog1.FileName);
                }
                else
                {
                    MessageBox.Show("haven't uploaded", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    log.Info("Провалена загрузка из файла " + openFileDialog1.FileName);
                }
                Draw();
            }
        }

        private void buttonSort_Click(object sender, EventArgs e)
        {
            depo.Sort();
            Draw();
            log.Info("Сортировка уровня " + depo.CurrentLevel);
        }
    }
}
