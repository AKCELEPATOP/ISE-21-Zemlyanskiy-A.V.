using NLog;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Laba2
{
    public partial class FormSelectLoc : Form
    {

        private ITransport loc = null;

        public ITransport getLoc { get { return loc; } }

        private event Del eventAddLoc;

        private Logger log;

        public FormSelectLoc(Logger log)
        {
            InitializeComponent();
            panelGreen.MouseDown += panelColor_MouseDown;
            panelBlack.MouseDown += panelColor_MouseDown;
            panelBlue.MouseDown += panelColor_MouseDown;
            panelGold.MouseDown += panelColor_MouseDown;
            panelGray.MouseDown += panelColor_MouseDown;
            panelMagenta.MouseDown += panelColor_MouseDown;
            panelPurple.MouseDown += panelColor_MouseDown;
            panelYellow.MouseDown += panelColor_MouseDown;
            this.log = log;

            buttonCancel.Click += (object sender, EventArgs e) => { Close(); };
        }

        private void Draw()
        {
            if (loc != null)
            {
                Bitmap main = new Bitmap(pictureBoxLoc.Width, pictureBoxLoc.Height);
                loc.setPosition(pictureBoxLoc.Width >> 1, pictureBoxLoc.Height >> 1);
                Graphics g = Graphics.FromImage(main);
                Rotate.rotate(g, loc.Pict, 0, loc.Center);
                pictureBoxLoc.Image = main;
            }
        }

        private void panelLoc_DragDrop(object sender, DragEventArgs e)
        {
            switch (e.Data.GetData(DataFormats.Text).ToString())
            {
                case "Locomotive":
                    loc = new Locomotive(200, 5, 100, 200, Color.DarkGreen, Color.LightGray);
                    labelMainColor.BackColor = Color.DarkGreen;
                    labelDopColor.BackColor = Color.LightGray;
                    break;
                case "Heatovoz":
                    loc = new Heatovoz(200, 5, 100, 200, Color.DarkGreen,
                        Color.LightGray, true, true, 100, Color.LightGray);
                    labelMainColor.BackColor = Color.DarkGreen;
                    labelDopColor.BackColor = Color.LightGray;
                    labelChimneyColor.BackColor = Color.LightGray;
                    break;
            }
            log.Info("Выбран новый " + loc.GetType().Name);
            Draw();
        }

        private void panelLoc_DragEnter(object sender, DragEventArgs e)
        {
            if (e.Data.GetDataPresent(DataFormats.Text))
            {
                e.Effect = DragDropEffects.Copy;
            }
            else
            {
                e.Effect = DragDropEffects.None;
            }
        }

        private void labelMainColor_DragDrop(object sender, DragEventArgs e)
        {
            if (loc != null)
            {
                loc.setMainColor((Color)e.Data.GetData(typeof(Color)));
                (sender as Control).BackColor = (Color)e.Data.GetData(typeof(Color));
                log.Info("Основной цвет изменен на " + (sender as Control).BackColor.Name);
                Draw();
            }
        }

        private void labelMainColor_DragEnter(object sender, DragEventArgs e)
        {
            if (e.Data.GetDataPresent(typeof(Color)))
            {
                e.Effect = DragDropEffects.Copy;
            }
            else
            {
                e.Effect = DragDropEffects.None;
            }
        }

        private void labelDopColor_DragDrop(object sender, DragEventArgs e)
        {
            if (loc != null)
            {
                loc.setDopColor((Color)e.Data.GetData(typeof(Color)));
                (sender as Control).BackColor = (Color)e.Data.GetData(typeof(Color));
                Draw();
                log.Info("Дополнительный цвет изменен на " + (sender as Control).BackColor.Name);
            }
        }

        private void label_MouseDown(object sender, MouseEventArgs e)
        {
            (sender as Label).DoDragDrop((sender as Label).Text, DragDropEffects.Move | DragDropEffects.Copy);
        }

        private void panelColor_MouseDown(object sender, MouseEventArgs e)
        {
            (sender as Control).DoDragDrop((sender as Control).BackColor,
                DragDropEffects.Move | DragDropEffects.Copy);
        }

        private void labelChimneyColor_DragDrop(object sender, DragEventArgs e)
        {
            if (loc != null)
            {
                if (loc is Heatovoz)
                {
                    (loc as Heatovoz).setChimneyColor((Color)e.Data.GetData(typeof(Color)));
                    (sender as Control).BackColor = (Color)e.Data.GetData(typeof(Color));
                    Draw();
                    log.Info("Цвет трубы изменен на " + (sender as Control).BackColor.Name);
                }
            }
        }

        public void AddEvent(Del ev)
        {
            if (eventAddLoc != null)
            {
                eventAddLoc = new Del(ev);
            }
            else
            {
                eventAddLoc += ev;
            }
        }

        private void buttonAdd_Click(object sender, EventArgs e)
        {
            if (eventAddLoc != null)
            {
                eventAddLoc(loc);
            }
            Close();
        }
    }
}
