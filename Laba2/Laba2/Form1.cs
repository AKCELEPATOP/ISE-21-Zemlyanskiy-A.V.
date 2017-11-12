using System;
using System.Drawing;
using System.Windows.Forms;

namespace Laba2
{
    public partial class Form1 : Form
    {

        Depo depo;

        FormSelectLoc form;


        public Form1()
        {
            InitializeComponent();
            depo = new Depo(5);
            for(int i = 0; i < 6; ++i)
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
        }

        private void buttonLvlUp_Click(object sender, EventArgs e)
        {
            depo.LevelUp();
            listBoxLevels.SelectedIndex = depo.CurrentLevel;
            Draw();
        }

        private void buttonGet_Click(object sender, EventArgs e)
        {
            if (listBoxLevels.SelectedIndex > -1)
            {
                if (maskedTextBox1.Text != "")
                {
                    var loc = depo.GetLocIntDepo(Convert.ToInt32(maskedTextBox1.Text));
                    loc.setPosition(pictureBox1.Width >> 1, pictureBox1.Height >> 1);
                    Bitmap main = new Bitmap(pictureBox1.Width, pictureBox1.Height);
                    Graphics g = Graphics.FromImage(main);
                    Rotate.rotate(g, loc.Pict, 0, loc.Center);
                    pictureBox1.Image = main;
                    Draw();
                }
            }
        }

        private void listBoxLevels_SelectedIndexChanged(object sender, EventArgs e)
        {
            depo.CurrentLevel = listBoxLevels.SelectedIndex;
            Draw();
        }

        private void buttonOrder_Click(object sender, EventArgs e)
        {
            form = new FormSelectLoc();
            form.AddEvent(addLoc);
            form.Show();
        }

        private void addLoc(ITransport shit)
        {
            if (shit != null)
            {
                int place = depo.PutLocInDepo(shit);
                if (place > -1)
                {
                    Draw();
                    MessageBox.Show("Ваше место: " + place);
                }
                else
                {
                    MessageBox.Show("Хьстон, у нас проблемы");
                }
            }
        }


    }
}
