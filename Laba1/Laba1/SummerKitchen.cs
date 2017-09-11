using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Laba1
{
    public partial class SummerKitchen : Form
    {
        private pig meat;

        private BlackPepper black_pepper;

        private coal coal;

        private dish dish;

        private GorikiyPepper gor_pepper;

        private grille grille;

        private klukva klukva;

        private Knife knife;

        private kvas kvas;

        private oil oil;

        private pan pan;

        private petrushka petrushka;

        private salt salt;

        private stove stove;

        private WaterTap tap;

        public SummerKitchen()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            dish = new dish();
            grille = new grille();
            knife = new Knife();
            pan = new pan();
            stove = new stove();
            tap = new WaterTap();
        }
        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void label6_Click(object sender, EventArgs e)
        {

        }

        private void numericUpDown6_ValueChanged(object sender, EventArgs e)
        {
            gor_pepper = new GorikiyPepper();
            if (numericGor.Value > 0)
            {
                gor_perec.Enabled = true;
                numericGor.Enabled = false;
                if (radioButton1.Checked) perec_wash.Visible = true;
            }
        }

        private void label9_Click(object sender, EventArgs e)
        {

        }
        
        private void numericUpDown1_ValueChanged(object sender, EventArgs e)
        {
            meat = new pig();
            if (numericPig.Value >= 1500)
            {
                pig.Enabled = true;
                numericPig.Enabled = false;
                if (radioButton1.Checked) pig_wash.Visible = true;
            }
        }

        private void numericUpDown4_ValueChanged(object sender, EventArgs e)
        {
            if (kvas == null) kvas = new kvas();
            kvas.volume = (int)numericKvas.Value;
            if (kvas.volume >= 200)
            {
                kvasik.Enabled = true;
                numericKvas.Enabled = false;
                if (isReadyToMarinade()) add_others.Visible = true;
            }
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {
            if (radioButton1.Checked)
            {
                if (pig.Enabled) pig_wash.Visible = true;
                if (gor_perec.Enabled) perec_wash.Visible = true;
                if (petrusha.Enabled) petrushka_wash.Visible = true;
                tap.State = true;
            }
        }

        private void numericUpDown7_ValueChanged(object sender, EventArgs e)
        {
            if(petrushka==null)petrushka = new petrushka();
            if (numericPetrusha.Value > 0)
            {
                petrusha.Enabled = true;
                numericPetrusha.Enabled = false;
                if (radioButton1.Checked) petrushka_wash.Visible = true;
            }
        }

        private void radioButton2_CheckedChanged(object sender, EventArgs e)
        {
            if (radioButton2.Checked)
            {
                if(pig_wash.Enabled)pig_wash.Visible = false;
                if (perec_wash.Enabled) perec_wash.Visible = false;
                if (petrushka_wash.Enabled) petrushka_wash.Visible = false;
                tap.State = false;
            }
        }

        private void pig_wash_Click(object sender, EventArgs e)
        {
            tap.Wash(meat);
            if(meat.Dirty==0)zarezat.Visible = true;
            pig_wash.Enabled = false;
        }

        private void perec_wash_Click(object sender, EventArgs e)
        {
            tap.Wash(gor_pepper);
            if (gor_pepper.Dirty == 0) sherdding_pepper.Visible = true;
            perec_wash.Enabled = false;
        }

        private void petrushka_wash_Click(object sender, EventArgs e)
        {
            tap.Wash(petrushka);
            petrushka_wash.Enabled = false;
            if (dish.isMeat) put_petr.Visible = true;
        }

        private void zarezat_Click(object sender, EventArgs e)
        {
            if (meat.Dirty == 0) knife.Sredding(meat);
            zarezat.Enabled = false;
            if (pan.MarinadeReady) add_meat.Visible = true;
        }

        private void shredding_klukva_Click(object sender, EventArgs e)
        {
            knife.Sredding(klukva);
            shredding_klukva.Enabled = false;
            if (isReadyToMarinade()) add_others.Visible = true;
        }

        private void numericUpDown3_ValueChanged(object sender, EventArgs e)
        {
            oil = new oil();
            if (numericOil.Value >= 200)
            {
                numericOil.Enabled = false;
                labelOil.Enabled = true;
                add_oil.Visible = true;
            }
        }

        private void add_oil_Click(object sender, EventArgs e)
        {
            pan.AddOil(oil);
            //oil = null;
            if (stove.State == true) put_pan.Visible = true;
            else MessageBox.Show("Масло нужно растопить", "Кухня", MessageBoxButtons.OK, MessageBoxIcon.Information);
            add_oil.Enabled = false;
        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            stove.State = checkBox1.Checked;
            if (stove.State && pan.OilIn) put_pan.Visible = true;
        }

        private void put_pan_Click(object sender, EventArgs e)
        {
            if (pan.OilIn)
                while (!pan.OilReady) pan.GetHeat();
            MessageBox.Show("Масло готово", "Кухня", MessageBoxButtons.OK, MessageBoxIcon.Information);
            checkBox1.Checked = false;
            put_pan.Enabled = false;
            get_pan.Visible = true;
        }

        private bool isReadyToMarinade()
        {
            if (klukva == null) return false;
            else if (klukva.Has_sredded != 10) return false;

            if(gor_pepper==null) return false;
            else if (gor_pepper.Has_sredded != 10) return false;

            if (!pan.OilReady) return false;

            if (black_pepper == null) return false;
            else if (black_pepper.Count != black_pepper.NeedCount) return false;

            if (salt == null) return false;
            else if (salt.Count != salt.NeedCount) return false;

            if (kvas == null) return false;
            if (kvas.volume != kvas.NeedVolume) return false;

            return true;
        }

        private void get_pan_Click(object sender, EventArgs e)
        {
            if (isReadyToMarinade()) add_others.Visible = true;
            get_pan.Enabled = false;
        }

        private void numericUpDown2_ValueChanged(object sender, EventArgs e)
        {
            if (klukva == null) klukva = new klukva();
            klukva.Weight = (int)numericKlukva.Value;
            if (klukva.Weight >= 200)
            {
                shredding_klukva.Visible = true;
                kuka.Enabled = true;
                numericKlukva.Enabled = false;
            }
        }

        private void sherdding_pepper_Click(object sender, EventArgs e)
        {
            knife.Sredding(gor_pepper);
            sherdding_pepper.Enabled = false;
            if (isReadyToMarinade()) add_others.Visible = true;
        }

        private void numericUpDown5_ValueChanged(object sender, EventArgs e)
        {
            if (black_pepper == null) black_pepper = new BlackPepper();
            black_pepper.Count = (int)numericBlack.Value;
            if (black_pepper.Count >= 100)
            {
                numericBlack.Enabled = false;
                if (isReadyToMarinade()) add_others.Visible = true;
                bl_per.Enabled = true;
            }
        }

        private void numericSalt_ValueChanged(object sender, EventArgs e)
        {
            if (salt == null) salt = new salt();
            salt.Count = (int)numericSalt.Value;
            if (salt.Count >= 100)
            {
                numericSalt.Enabled = false;
                labelSalt.Enabled = true;
                if (isReadyToMarinade()) add_others.Visible = true;
            }
        }

        private void numericCoal_ValueChanged(object sender, EventArgs e)
        {
            if (coal == null) coal = new coal();
            coal.Weight = (int)numericCoal.Value;
            if (coal.Weight >= 2000)
            {
                numericCoal.Enabled = false;
                labelCoal.Enabled = true;
                add_coal.Visible = true;
            }
        }

        private void add_others_Click(object sender, EventArgs e)
        {
            add_others.Enabled = false;
            pan.CreateMarinade(klukva, kvas, salt, gor_pepper, black_pepper);
            klukva = null;salt = null;kvas = null;gor_pepper = null;black_pepper = null;
            if (meat.Has_sredded == 10) add_meat.Visible = true;
        }

        private void add_meat_Click(object sender, EventArgs e)
        {
            pan.addMeat(meat);
            meat = null;
            if (pan.MeatIn)
                while (!pan.ReadyToCook) pan.GetMarinade();
            get_meat.Visible = true;
            add_meat.Enabled = false;
            MessageBox.Show("Мясо замариновалось", "Кухня", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }

        private void get_meat_Click(object sender, EventArgs e)
        {
            meat = pan.GetMeat();
            if (!grille.CoalReady())
                MessageBox.Show("Пора приготовить угли", "Кухня", MessageBoxButtons.OK, MessageBoxIcon.Information);
            else put_meat.Visible = true;
            get_meat.Enabled = false;
            if (grille.CoalReady()) put_meat.Visible = true;
            /*if (grille.CoalReady())
                while (!grille.isReady) grille.Cook();*/
        }

        private void add_coal_Click(object sender, EventArgs e)
        {
            add_coal.Enabled = false;
            if (coal != null) grille.Coal = coal;
            else
            {
                MessageBox.Show("Чурки уголь спиздили. Добавить ещё угля?", "Кухня", MessageBoxButtons.OK, MessageBoxIcon.Information);
                coal = new coal();
                coal.Weight = 2000;
            }
            grille.Coal.IsBurning = true;
            while (!grille.CoalReady())
                grille.CookCoal();
            if (meat == null|| !meat.Has_zamarinade) MessageBox.Show("Займись мясом", "Кухня", MessageBoxButtons.OK, MessageBoxIcon.Information);
            else put_meat.Visible = true;
        }

        private void put_meat_Click(object sender, EventArgs e)
        {
            put_meat.Enabled = false;
            grille.Meat = meat;
            meat = null;
            while (!grille.isReady)
                grille.Cook();
            meat = grille.Meat;
            if (meat.Has_ready)
            {
                MessageBox.Show("Мясо готово, теперь украсим зеленью", "Кухня", MessageBoxButtons.OK, MessageBoxIcon.Information);
                kushat.Visible = true;
            }
        }

        private void kushat_Click(object sender, EventArgs e)
        {
            kushat.Enabled = false;
            dish.Meat = meat;
            meat = null;
            if (petrushka.Dirty == 0) put_petr.Visible = true;
            else MessageBox.Show("Петрушка то грязная", "Кухня", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }

        private void put_petr_Click(object sender, EventArgs e)
        {
            put_petr.Enabled = false;
            dish.Petrushka = petrushka;
            petrushka = null;
            MessageBox.Show("Шашлык из свинины готов!", "Кухня", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }
    }
}
