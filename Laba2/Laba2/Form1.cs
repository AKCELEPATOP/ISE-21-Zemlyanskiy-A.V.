﻿using System;
using System.Drawing;
using System.Windows.Forms;

namespace Laba2
{
    public partial class Form1 : Form
    {
        ITransport shit;
        Color color;
        Color dopColor;
        Color chimneyColor;
        int maxCountPassegers;
        double carrying;
        double weight;
        int maxSpeed;
        int countFuel;


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
            if (cheakFields())
            {
                shit = new Locomotive(maxSpeed, maxCountPassegers, weight, carrying, color,dopColor);
                Bitmap bmp = new Bitmap(PicWidth, PicHeight);
                Graphics gr = Graphics.FromImage(bmp);
                shit.setPosition(PicWidth >> 1, PicHeight - (shit.bodyHeight >> 1));
                shit.draw(gr);
                pictureBoxDraw.Image = bmp;
            }
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
            if (cheakFields() && isFuel())
            {
                shit = new Heatovoz(maxSpeed, maxCountPassegers, weight, carrying, color, dopColor,checkBoxBotm.Checked, checkBoxTop.Checked, countFuel , chimneyColor);
                Bitmap bmp = new Bitmap(PicWidth, PicHeight);
                Graphics gr = Graphics.FromImage(bmp);
                shit.setPosition(PicWidth >> 1, PicHeight - (shit.bodyHeight >> 1));
                shit.draw(gr);
                pictureBoxDraw.Image = bmp;
            }
        }

        private void buttonMove_Click(object sender, EventArgs e)
        {
            Bitmap bmp = new Bitmap(PicWidth, PicHeight);
            Graphics gr = Graphics.FromImage(bmp);
            shit.move(gr);
            pictureBoxDraw.Image = bmp;
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
    }
}