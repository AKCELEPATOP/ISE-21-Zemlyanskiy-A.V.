namespace Laba2
{
    partial class Form1
    {
        /// <summary>
        /// Обязательная переменная конструктора.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        private int pictureWidth = 120;
        private int pictureHeight = 217;

        public int PicWidth { get { return pictureWidth; } }
        public int PicHeight { get { return pictureHeight; } }
        /// <summary>
        /// Освободить все используемые ресурсы.
        /// </summary>
        /// <param name="disposing">истинно, если управляемый ресурс должен быть удален; иначе ложно.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Код, автоматически созданный конструктором форм Windows

        /// <summary>
        /// Требуемый метод для поддержки конструктора — не изменяйте 
        /// содержимое этого метода с помощью редактора кода.
        /// </summary>
        private void InitializeComponent()
        {
            this.pictureBoxDraw = new System.Windows.Forms.PictureBox();
            this.groupGetLoc = new System.Windows.Forms.GroupBox();
            this.listBoxLevels = new System.Windows.Forms.ListBox();
            this.buttonLvlDown = new System.Windows.Forms.Button();
            this.buttonLvlUp = new System.Windows.Forms.Button();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.buttonGet = new System.Windows.Forms.Button();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.maskedTextBox1 = new System.Windows.Forms.MaskedTextBox();
            this.buttonOrder = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxDraw)).BeginInit();
            this.groupGetLoc.SuspendLayout();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // pictureBoxDraw
            // 
            this.pictureBoxDraw.BackColor = System.Drawing.Color.White;
            this.pictureBoxDraw.Location = new System.Drawing.Point(0, 1);
            this.pictureBoxDraw.Name = "pictureBoxDraw";
            this.pictureBoxDraw.Size = new System.Drawing.Size(534, 382);
            this.pictureBoxDraw.TabIndex = 0;
            this.pictureBoxDraw.TabStop = false;
            // 
            // groupGetLoc
            // 
            this.groupGetLoc.Controls.Add(this.listBoxLevels);
            this.groupGetLoc.Location = new System.Drawing.Point(546, 12);
            this.groupGetLoc.Name = "groupGetLoc";
            this.groupGetLoc.Size = new System.Drawing.Size(149, 135);
            this.groupGetLoc.TabIndex = 23;
            this.groupGetLoc.TabStop = false;
            this.groupGetLoc.Text = "Уровни:";
            // 
            // listBoxLevels
            // 
            this.listBoxLevels.FormattingEnabled = true;
            this.listBoxLevels.Location = new System.Drawing.Point(10, 23);
            this.listBoxLevels.Name = "listBoxLevels";
            this.listBoxLevels.Size = new System.Drawing.Size(128, 95);
            this.listBoxLevels.TabIndex = 0;
            this.listBoxLevels.SelectedIndexChanged += new System.EventHandler(this.listBoxLevels_SelectedIndexChanged);
            // 
            // buttonLvlDown
            // 
            this.buttonLvlDown.Location = new System.Drawing.Point(546, 153);
            this.buttonLvlDown.Name = "buttonLvlDown";
            this.buttonLvlDown.Size = new System.Drawing.Size(64, 29);
            this.buttonLvlDown.TabIndex = 24;
            this.buttonLvlDown.Text = "Prev";
            this.buttonLvlDown.UseVisualStyleBackColor = true;
            this.buttonLvlDown.Click += new System.EventHandler(this.buttonLvlDown_Click);
            // 
            // buttonLvlUp
            // 
            this.buttonLvlUp.Location = new System.Drawing.Point(631, 153);
            this.buttonLvlUp.Name = "buttonLvlUp";
            this.buttonLvlUp.Size = new System.Drawing.Size(64, 29);
            this.buttonLvlUp.TabIndex = 25;
            this.buttonLvlUp.Text = "Next";
            this.buttonLvlUp.UseVisualStyleBackColor = true;
            this.buttonLvlUp.Click += new System.EventHandler(this.buttonLvlUp_Click);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.buttonGet);
            this.groupBox1.Controls.Add(this.pictureBox1);
            this.groupBox1.Controls.Add(this.maskedTextBox1);
            this.groupBox1.Location = new System.Drawing.Point(546, 188);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(149, 254);
            this.groupBox1.TabIndex = 26;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Забрать локомотив";
            // 
            // buttonGet
            // 
            this.buttonGet.Location = new System.Drawing.Point(13, 48);
            this.buttonGet.Name = "buttonGet";
            this.buttonGet.Size = new System.Drawing.Size(90, 20);
            this.buttonGet.TabIndex = 1;
            this.buttonGet.Text = "Получить";
            this.buttonGet.UseVisualStyleBackColor = true;
            this.buttonGet.Click += new System.EventHandler(this.buttonGet_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackColor = System.Drawing.Color.White;
            this.pictureBox1.Location = new System.Drawing.Point(6, 74);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(135, 170);
            this.pictureBox1.TabIndex = 22;
            this.pictureBox1.TabStop = false;
            // 
            // maskedTextBox1
            // 
            this.maskedTextBox1.Location = new System.Drawing.Point(6, 19);
            this.maskedTextBox1.Mask = "00";
            this.maskedTextBox1.Name = "maskedTextBox1";
            this.maskedTextBox1.Size = new System.Drawing.Size(49, 20);
            this.maskedTextBox1.TabIndex = 0;
            // 
            // buttonOrder
            // 
            this.buttonOrder.Location = new System.Drawing.Point(380, 404);
            this.buttonOrder.Name = "buttonOrder";
            this.buttonOrder.Size = new System.Drawing.Size(154, 38);
            this.buttonOrder.TabIndex = 27;
            this.buttonOrder.Text = "order the loc";
            this.buttonOrder.UseVisualStyleBackColor = true;
            this.buttonOrder.Click += new System.EventHandler(this.buttonOrder_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(707, 453);
            this.Controls.Add(this.buttonOrder);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.buttonLvlUp);
            this.Controls.Add(this.buttonLvlDown);
            this.Controls.Add(this.groupGetLoc);
            this.Controls.Add(this.pictureBoxDraw);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxDraw)).EndInit();
            this.groupGetLoc.ResumeLayout(false);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.PictureBox pictureBoxDraw;
        private System.Windows.Forms.GroupBox groupGetLoc;
        private System.Windows.Forms.ListBox listBoxLevels;
        private System.Windows.Forms.Button buttonLvlDown;
        private System.Windows.Forms.Button buttonLvlUp;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Button buttonGet;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.MaskedTextBox maskedTextBox1;
        private System.Windows.Forms.Button buttonOrder;
    }
}

