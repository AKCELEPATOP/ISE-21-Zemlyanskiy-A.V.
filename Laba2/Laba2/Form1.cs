using System;
using System.Drawing;
using System.Windows.Forms;

namespace Laba2
{
    public partial class Form1 : Form
    {
        Color color;
        Color dopColor;
        Color chimneyColor;
        int maxCountPassegers;
        double carrying;
        double weight;
        int maxSpeed;
        int countFuel;

        Depo depo;


        public Form1()
        {
            InitializeComponent();
            maxCountPassegers = 2;
            maxSpeed = 300;
            weight = 100;
            carrying = 200;
            countFuel = 50;
            color = Color.DarkGreen;
            dopColor = Color.LightGray;
            chimneyColor = Color.LightGray;
            button1.BackColor = color;
            button2.BackColor = dopColor;
            button3.BackColor = chimneyColor;
            depo = new Depo();
            Draw();
        }

        private void Draw()
        {
            Bitmap bmp = new Bitmap(pictureBoxDraw.Width, pictureBoxDraw.Height);
            Graphics gr = Graphics.FromImage(bmp);
            depo.Draw(gr);
            pictureBoxDraw.Image = bmp;
        }


        private void Form1_Load(object sender, EventArgs e)
        {


        }

        private void button1_Click(object sender, EventArgs e)
        {
            ColorDialog cd = new ColorDialog();
            if (cd.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            {
                color = cd.Color;
                button1.BackColor = color;
            }

        }
        private bool cheakFields()
        {
            if (!int.TryParse(Max_Speed.Text, out maxSpeed))
            {
                return false;
            }
            if (!int.TryParse(Passegers.Text, out maxCountPassegers))
            {
                return false;
            }
            if (!double.TryParse(Carryng.Text, out carrying))
            {
                return false;
            }
            if (!double.TryParse(Weight.Text, out weight))
            {
                return false;
            }
            return true;
        }
        private bool isFuel()
        {
            if (!int.TryParse(textFuel.Text, out countFuel))
            {
                return false;
            }
            return true;
        }

        private void buttonLoc_Click(object sender, EventArgs e)
        {
            var shit = new Locomotive(200, 5, 100, 200, color, dopColor);
            int place = depo.PutLocInDepo(shit);
            Draw();
            MessageBox.Show("Ваше место: " + place);

        }

        private void button2_Click(object sender, EventArgs e)
        {
            ColorDialog cd = new ColorDialog();
            if (cd.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            {
                dopColor = cd.Color;
                button2.BackColor = dopColor;
            }
        }

        private void buttonHeat_Click(object sender, EventArgs e)
        {
            var shit = new Heatovoz(200, 5, 100, 200, color, dopColor, true, true, 100, chimneyColor);
            int place = depo.PutLocInDepo(shit);
            Draw();
            MessageBox.Show("Ваше место: " + place);
        }

        private void button3_Click(object sender, EventArgs e)
        {
            ColorDialog cd = new ColorDialog();
            if (cd.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            {
                chimneyColor = cd.Color;
                button3.BackColor = chimneyColor;
            }
        }

        private void maskedTextBox1_MaskInputRejected(object sender, MaskInputRejectedEventArgs e)
        {

        }

        private void buttonGet_Click(object sender, EventArgs e)
        {

            if (maskedTextBox1.Text != "")
            {
                var loc = depo.GetLocIntDepo(Convert.ToInt32(maskedTextBox1.Text));
                Bitmap bmp = new Bitmap(30, 100);
                Graphics gr = Graphics.FromImage(bmp);
                loc.setPosition(pictureBox1.Width >> 1, pictureBox1.Height >> 1);
                loc.draw(gr);
                Bitmap main = new Bitmap(pictureBox1.Width, pictureBox1.Height);
                Graphics g = Graphics.FromImage(main);
                g.DrawImage(bmp, loc.Center);
                pictureBox1.Image = main;
                Draw();
            }
        }
    }
}
