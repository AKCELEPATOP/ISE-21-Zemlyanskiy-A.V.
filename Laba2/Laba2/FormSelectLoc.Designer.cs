namespace Laba2
{
    partial class FormSelectLoc
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.labelLoc = new System.Windows.Forms.Label();
            this.panelLoc = new System.Windows.Forms.Panel();
            this.labelChimneyColor = new System.Windows.Forms.Label();
            this.labelDopColor = new System.Windows.Forms.Label();
            this.labelMainColor = new System.Windows.Forms.Label();
            this.pictureBoxLoc = new System.Windows.Forms.PictureBox();
            this.panelGreen = new System.Windows.Forms.Panel();
            this.panelGray = new System.Windows.Forms.Panel();
            this.panelBlue = new System.Windows.Forms.Panel();
            this.panelMagenta = new System.Windows.Forms.Panel();
            this.panelBlack = new System.Windows.Forms.Panel();
            this.panelPurple = new System.Windows.Forms.Panel();
            this.panelGold = new System.Windows.Forms.Panel();
            this.panelYellow = new System.Windows.Forms.Panel();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.labelHeat = new System.Windows.Forms.Label();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.buttonAdd = new System.Windows.Forms.Button();
            this.buttonCancel = new System.Windows.Forms.Button();
            this.panelLoc.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxLoc)).BeginInit();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // labelLoc
            // 
            this.labelLoc.AutoSize = true;
            this.labelLoc.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.labelLoc.Location = new System.Drawing.Point(6, 19);
            this.labelLoc.Name = "labelLoc";
            this.labelLoc.Size = new System.Drawing.Size(80, 17);
            this.labelLoc.TabIndex = 1;
            this.labelLoc.Text = "Locomotive";
            this.labelLoc.MouseDown += new System.Windows.Forms.MouseEventHandler(this.label_MouseDown);
            // 
            // panelLoc
            // 
            this.panelLoc.AllowDrop = true;
            this.panelLoc.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.panelLoc.Controls.Add(this.labelChimneyColor);
            this.panelLoc.Controls.Add(this.labelDopColor);
            this.panelLoc.Controls.Add(this.labelMainColor);
            this.panelLoc.Controls.Add(this.pictureBoxLoc);
            this.panelLoc.Location = new System.Drawing.Point(12, 12);
            this.panelLoc.Name = "panelLoc";
            this.panelLoc.Size = new System.Drawing.Size(214, 215);
            this.panelLoc.TabIndex = 2;
            this.panelLoc.DragDrop += new System.Windows.Forms.DragEventHandler(this.panelLoc_DragDrop);
            this.panelLoc.DragEnter += new System.Windows.Forms.DragEventHandler(this.panelLoc_DragEnter);
            // 
            // labelChimneyColor
            // 
            this.labelChimneyColor.AllowDrop = true;
            this.labelChimneyColor.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.labelChimneyColor.Location = new System.Drawing.Point(145, 172);
            this.labelChimneyColor.Name = "labelChimneyColor";
            this.labelChimneyColor.Size = new System.Drawing.Size(60, 30);
            this.labelChimneyColor.TabIndex = 3;
            this.labelChimneyColor.Text = "Chimney";
            this.labelChimneyColor.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.labelChimneyColor.DragDrop += new System.Windows.Forms.DragEventHandler(this.labelChimneyColor_DragDrop);
            this.labelChimneyColor.DragEnter += new System.Windows.Forms.DragEventHandler(this.labelMainColor_DragEnter);
            // 
            // labelDopColor
            // 
            this.labelDopColor.AllowDrop = true;
            this.labelDopColor.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.labelDopColor.Location = new System.Drawing.Point(145, 136);
            this.labelDopColor.Name = "labelDopColor";
            this.labelDopColor.Size = new System.Drawing.Size(60, 30);
            this.labelDopColor.TabIndex = 2;
            this.labelDopColor.Text = "Secondary";
            this.labelDopColor.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.labelDopColor.DragDrop += new System.Windows.Forms.DragEventHandler(this.labelDopColor_DragDrop);
            this.labelDopColor.DragEnter += new System.Windows.Forms.DragEventHandler(this.labelMainColor_DragEnter);
            // 
            // labelMainColor
            // 
            this.labelMainColor.AllowDrop = true;
            this.labelMainColor.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.labelMainColor.Location = new System.Drawing.Point(145, 100);
            this.labelMainColor.Name = "labelMainColor";
            this.labelMainColor.Size = new System.Drawing.Size(60, 30);
            this.labelMainColor.TabIndex = 1;
            this.labelMainColor.Text = "Main";
            this.labelMainColor.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.labelMainColor.DragDrop += new System.Windows.Forms.DragEventHandler(this.labelMainColor_DragDrop);
            this.labelMainColor.DragEnter += new System.Windows.Forms.DragEventHandler(this.labelMainColor_DragEnter);
            // 
            // pictureBoxLoc
            // 
            this.pictureBoxLoc.BackColor = System.Drawing.Color.White;
            this.pictureBoxLoc.Location = new System.Drawing.Point(0, 0);
            this.pictureBoxLoc.Name = "pictureBoxLoc";
            this.pictureBoxLoc.Size = new System.Drawing.Size(139, 202);
            this.pictureBoxLoc.TabIndex = 0;
            this.pictureBoxLoc.TabStop = false;
            // 
            // panelGreen
            // 
            this.panelGreen.BackColor = System.Drawing.Color.DarkGreen;
            this.panelGreen.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panelGreen.Location = new System.Drawing.Point(6, 21);
            this.panelGreen.Name = "panelGreen";
            this.panelGreen.Size = new System.Drawing.Size(40, 40);
            this.panelGreen.TabIndex = 3;
            this.panelGreen.MouseDown += new System.Windows.Forms.MouseEventHandler(this.panelColor_MouseDown);
            // 
            // panelGray
            // 
            this.panelGray.BackColor = System.Drawing.Color.LightGray;
            this.panelGray.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panelGray.Location = new System.Drawing.Point(52, 21);
            this.panelGray.Name = "panelGray";
            this.panelGray.Size = new System.Drawing.Size(40, 40);
            this.panelGray.TabIndex = 4;
            // 
            // panelBlue
            // 
            this.panelBlue.BackColor = System.Drawing.Color.Blue;
            this.panelBlue.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panelBlue.Location = new System.Drawing.Point(6, 67);
            this.panelBlue.Name = "panelBlue";
            this.panelBlue.Size = new System.Drawing.Size(40, 40);
            this.panelBlue.TabIndex = 5;
            // 
            // panelMagenta
            // 
            this.panelMagenta.BackColor = System.Drawing.Color.Magenta;
            this.panelMagenta.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panelMagenta.Location = new System.Drawing.Point(52, 113);
            this.panelMagenta.Name = "panelMagenta";
            this.panelMagenta.Size = new System.Drawing.Size(40, 40);
            this.panelMagenta.TabIndex = 8;
            // 
            // panelBlack
            // 
            this.panelBlack.BackColor = System.Drawing.Color.Black;
            this.panelBlack.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panelBlack.Location = new System.Drawing.Point(6, 113);
            this.panelBlack.Name = "panelBlack";
            this.panelBlack.Size = new System.Drawing.Size(40, 40);
            this.panelBlack.TabIndex = 7;
            // 
            // panelPurple
            // 
            this.panelPurple.BackColor = System.Drawing.Color.Purple;
            this.panelPurple.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panelPurple.Location = new System.Drawing.Point(52, 67);
            this.panelPurple.Name = "panelPurple";
            this.panelPurple.Size = new System.Drawing.Size(40, 40);
            this.panelPurple.TabIndex = 6;
            // 
            // panelGold
            // 
            this.panelGold.BackColor = System.Drawing.Color.Gold;
            this.panelGold.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panelGold.Location = new System.Drawing.Point(52, 159);
            this.panelGold.Name = "panelGold";
            this.panelGold.Size = new System.Drawing.Size(40, 40);
            this.panelGold.TabIndex = 10;
            // 
            // panelYellow
            // 
            this.panelYellow.BackColor = System.Drawing.Color.Yellow;
            this.panelYellow.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panelYellow.Location = new System.Drawing.Point(6, 159);
            this.panelYellow.Name = "panelYellow";
            this.panelYellow.Size = new System.Drawing.Size(40, 40);
            this.panelYellow.TabIndex = 9;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.panelGold);
            this.groupBox1.Controls.Add(this.panelYellow);
            this.groupBox1.Controls.Add(this.panelMagenta);
            this.groupBox1.Controls.Add(this.panelBlack);
            this.groupBox1.Controls.Add(this.panelPurple);
            this.groupBox1.Controls.Add(this.panelBlue);
            this.groupBox1.Controls.Add(this.panelGray);
            this.groupBox1.Controls.Add(this.panelGreen);
            this.groupBox1.Location = new System.Drawing.Point(235, 83);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(105, 211);
            this.groupBox1.TabIndex = 11;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Colors";
            // 
            // labelHeat
            // 
            this.labelHeat.AutoSize = true;
            this.labelHeat.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.labelHeat.Location = new System.Drawing.Point(6, 38);
            this.labelHeat.Name = "labelHeat";
            this.labelHeat.Size = new System.Drawing.Size(68, 17);
            this.labelHeat.TabIndex = 12;
            this.labelHeat.Text = "Heatovoz";
            this.labelHeat.MouseDown += new System.Windows.Forms.MouseEventHandler(this.label_MouseDown);
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.labelHeat);
            this.groupBox2.Controls.Add(this.labelLoc);
            this.groupBox2.Location = new System.Drawing.Point(238, 12);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(88, 58);
            this.groupBox2.TabIndex = 13;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Type";
            // 
            // buttonAdd
            // 
            this.buttonAdd.Location = new System.Drawing.Point(14, 269);
            this.buttonAdd.Name = "buttonAdd";
            this.buttonAdd.Size = new System.Drawing.Size(94, 25);
            this.buttonAdd.TabIndex = 14;
            this.buttonAdd.Text = "Add";
            this.buttonAdd.UseVisualStyleBackColor = true;
            this.buttonAdd.Click += new System.EventHandler(this.buttonAdd_Click);
            // 
            // buttonCancel
            // 
            this.buttonCancel.Location = new System.Drawing.Point(127, 269);
            this.buttonCancel.Name = "buttonCancel";
            this.buttonCancel.Size = new System.Drawing.Size(94, 25);
            this.buttonCancel.TabIndex = 15;
            this.buttonCancel.Text = "Cancel";
            this.buttonCancel.UseVisualStyleBackColor = true;
            // 
            // FormSelectLoc
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(343, 306);
            this.Controls.Add(this.buttonCancel);
            this.Controls.Add(this.buttonAdd);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.panelLoc);
            this.Name = "FormSelectLoc";
            this.Text = "FormSelectLoc";
            this.panelLoc.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxLoc)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.Label labelLoc;
        private System.Windows.Forms.Panel panelLoc;
        private System.Windows.Forms.PictureBox pictureBoxLoc;
        private System.Windows.Forms.Label labelChimneyColor;
        private System.Windows.Forms.Label labelDopColor;
        private System.Windows.Forms.Label labelMainColor;
        private System.Windows.Forms.Panel panelGreen;
        private System.Windows.Forms.Panel panelGray;
        private System.Windows.Forms.Panel panelBlue;
        private System.Windows.Forms.Panel panelMagenta;
        private System.Windows.Forms.Panel panelBlack;
        private System.Windows.Forms.Panel panelPurple;
        private System.Windows.Forms.Panel panelGold;
        private System.Windows.Forms.Panel panelYellow;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Label labelHeat;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Button buttonAdd;
        private System.Windows.Forms.Button buttonCancel;
    }
}