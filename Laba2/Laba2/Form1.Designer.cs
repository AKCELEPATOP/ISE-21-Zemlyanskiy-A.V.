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
            this.labelSpeed = new System.Windows.Forms.Label();
            this.Max_Speed = new System.Windows.Forms.TextBox();
            this.Passegers = new System.Windows.Forms.TextBox();
            this.labelPassagers = new System.Windows.Forms.Label();
            this.Weight = new System.Windows.Forms.TextBox();
            this.labelWeight = new System.Windows.Forms.Label();
            this.Carryng = new System.Windows.Forms.TextBox();
            this.labelCarrying = new System.Windows.Forms.Label();
            this.checkBoxTop = new System.Windows.Forms.CheckBox();
            this.checkBoxBotm = new System.Windows.Forms.CheckBox();
            this.buttonLoc = new System.Windows.Forms.Button();
            this.buttonHeat = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.button2 = new System.Windows.Forms.Button();
            this.buttonMove = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.button3 = new System.Windows.Forms.Button();
            this.textFuel = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.groupGetLoc = new System.Windows.Forms.GroupBox();
            this.buttonGet = new System.Windows.Forms.Button();
            this.maskedTextBox1 = new System.Windows.Forms.MaskedTextBox();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxDraw)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.groupGetLoc.SuspendLayout();
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
            // labelSpeed
            // 
            this.labelSpeed.AutoSize = true;
            this.labelSpeed.Location = new System.Drawing.Point(18, 403);
            this.labelSpeed.Name = "labelSpeed";
            this.labelSpeed.Size = new System.Drawing.Size(61, 13);
            this.labelSpeed.TabIndex = 1;
            this.labelSpeed.Text = "Max Speed";
            // 
            // Max_Speed
            // 
            this.Max_Speed.Location = new System.Drawing.Point(125, 400);
            this.Max_Speed.Name = "Max_Speed";
            this.Max_Speed.Size = new System.Drawing.Size(52, 20);
            this.Max_Speed.TabIndex = 2;
            // 
            // Passegers
            // 
            this.Passegers.Location = new System.Drawing.Point(125, 426);
            this.Passegers.Name = "Passegers";
            this.Passegers.Size = new System.Drawing.Size(52, 20);
            this.Passegers.TabIndex = 4;
            // 
            // labelPassagers
            // 
            this.labelPassagers.AutoSize = true;
            this.labelPassagers.Location = new System.Drawing.Point(18, 429);
            this.labelPassagers.Name = "labelPassagers";
            this.labelPassagers.Size = new System.Drawing.Size(108, 13);
            this.labelPassagers.TabIndex = 3;
            this.labelPassagers.Text = "Max count passegers";
            // 
            // Weight
            // 
            this.Weight.Location = new System.Drawing.Point(261, 400);
            this.Weight.Name = "Weight";
            this.Weight.Size = new System.Drawing.Size(52, 20);
            this.Weight.TabIndex = 6;
            // 
            // labelWeight
            // 
            this.labelWeight.AutoSize = true;
            this.labelWeight.Location = new System.Drawing.Point(194, 403);
            this.labelWeight.Name = "labelWeight";
            this.labelWeight.Size = new System.Drawing.Size(41, 13);
            this.labelWeight.TabIndex = 5;
            this.labelWeight.Text = "Weight";
            // 
            // Carryng
            // 
            this.Carryng.Location = new System.Drawing.Point(261, 426);
            this.Carryng.Name = "Carryng";
            this.Carryng.Size = new System.Drawing.Size(52, 20);
            this.Carryng.TabIndex = 8;
            // 
            // labelCarrying
            // 
            this.labelCarrying.AutoSize = true;
            this.labelCarrying.Location = new System.Drawing.Point(194, 429);
            this.labelCarrying.Name = "labelCarrying";
            this.labelCarrying.Size = new System.Drawing.Size(45, 13);
            this.labelCarrying.TabIndex = 7;
            this.labelCarrying.Text = "Carrying";
            // 
            // checkBoxTop
            // 
            this.checkBoxTop.AutoSize = true;
            this.checkBoxTop.Location = new System.Drawing.Point(335, 402);
            this.checkBoxTop.Name = "checkBoxTop";
            this.checkBoxTop.Size = new System.Drawing.Size(85, 17);
            this.checkBoxTop.TabIndex = 9;
            this.checkBoxTop.Text = "TopChimney";
            this.checkBoxTop.UseVisualStyleBackColor = true;
            // 
            // checkBoxBotm
            // 
            this.checkBoxBotm.AutoSize = true;
            this.checkBoxBotm.Location = new System.Drawing.Point(335, 428);
            this.checkBoxBotm.Name = "checkBoxBotm";
            this.checkBoxBotm.Size = new System.Drawing.Size(90, 17);
            this.checkBoxBotm.TabIndex = 10;
            this.checkBoxBotm.Text = "BotmChimney";
            this.checkBoxBotm.UseVisualStyleBackColor = true;
            // 
            // buttonLoc
            // 
            this.buttonLoc.Location = new System.Drawing.Point(115, 477);
            this.buttonLoc.Name = "buttonLoc";
            this.buttonLoc.Size = new System.Drawing.Size(100, 22);
            this.buttonLoc.TabIndex = 11;
            this.buttonLoc.Text = "set locomotive";
            this.buttonLoc.UseVisualStyleBackColor = true;
            this.buttonLoc.Click += new System.EventHandler(this.buttonLoc_Click);
            // 
            // buttonHeat
            // 
            this.buttonHeat.Location = new System.Drawing.Point(221, 477);
            this.buttonHeat.Name = "buttonHeat";
            this.buttonHeat.Size = new System.Drawing.Size(100, 22);
            this.buttonHeat.TabIndex = 12;
            this.buttonHeat.Text = "set heatovoz";
            this.buttonHeat.UseVisualStyleBackColor = true;
            this.buttonHeat.Click += new System.EventHandler(this.buttonHeat_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(478, 400);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(52, 19);
            this.button1.TabIndex = 13;
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(429, 403);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(31, 13);
            this.label1.TabIndex = 14;
            this.label1.Text = "Color";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(429, 429);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(49, 13);
            this.label2.TabIndex = 16;
            this.label2.Text = "dopColor";
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(478, 426);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(52, 19);
            this.button2.TabIndex = 15;
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // buttonMove
            // 
            this.buttonMove.Location = new System.Drawing.Point(446, 479);
            this.buttonMove.Name = "buttonMove";
            this.buttonMove.Size = new System.Drawing.Size(84, 20);
            this.buttonMove.TabIndex = 17;
            this.buttonMove.Text = "move";
            this.buttonMove.UseVisualStyleBackColor = true;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(429, 454);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(47, 13);
            this.label3.TabIndex = 19;
            this.label3.Text = "Chimney";
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(478, 451);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(52, 19);
            this.button3.TabIndex = 18;
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // textFuel
            // 
            this.textFuel.Location = new System.Drawing.Point(373, 450);
            this.textFuel.Name = "textFuel";
            this.textFuel.Size = new System.Drawing.Size(52, 20);
            this.textFuel.TabIndex = 21;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(306, 453);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(27, 13);
            this.label4.TabIndex = 20;
            this.label4.Text = "Fuel";
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackColor = System.Drawing.Color.White;
            this.pictureBox1.Location = new System.Drawing.Point(6, 74);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(135, 257);
            this.pictureBox1.TabIndex = 22;
            this.pictureBox1.TabStop = false;
            // 
            // groupGetLoc
            // 
            this.groupGetLoc.Controls.Add(this.buttonGet);
            this.groupGetLoc.Controls.Add(this.pictureBox1);
            this.groupGetLoc.Controls.Add(this.maskedTextBox1);
            this.groupGetLoc.Location = new System.Drawing.Point(546, 12);
            this.groupGetLoc.Name = "groupGetLoc";
            this.groupGetLoc.Size = new System.Drawing.Size(149, 337);
            this.groupGetLoc.TabIndex = 23;
            this.groupGetLoc.TabStop = false;
            this.groupGetLoc.Text = "Забрать локомотив";
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
            // maskedTextBox1
            // 
            this.maskedTextBox1.Location = new System.Drawing.Point(6, 19);
            this.maskedTextBox1.Mask = "00";
            this.maskedTextBox1.Name = "maskedTextBox1";
            this.maskedTextBox1.Size = new System.Drawing.Size(49, 20);
            this.maskedTextBox1.TabIndex = 0;
            this.maskedTextBox1.MaskInputRejected += new System.Windows.Forms.MaskInputRejectedEventHandler(this.maskedTextBox1_MaskInputRejected);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(707, 523);
            this.Controls.Add(this.groupGetLoc);
            this.Controls.Add(this.textFuel);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.button3);
            this.Controls.Add(this.buttonMove);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.buttonHeat);
            this.Controls.Add(this.buttonLoc);
            this.Controls.Add(this.checkBoxBotm);
            this.Controls.Add(this.checkBoxTop);
            this.Controls.Add(this.Carryng);
            this.Controls.Add(this.labelCarrying);
            this.Controls.Add(this.Weight);
            this.Controls.Add(this.labelWeight);
            this.Controls.Add(this.Passegers);
            this.Controls.Add(this.labelPassagers);
            this.Controls.Add(this.Max_Speed);
            this.Controls.Add(this.labelSpeed);
            this.Controls.Add(this.pictureBoxDraw);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxDraw)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.groupGetLoc.ResumeLayout(false);
            this.groupGetLoc.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox pictureBoxDraw;
        private System.Windows.Forms.Label labelSpeed;
        private System.Windows.Forms.TextBox Max_Speed;
        private System.Windows.Forms.TextBox Passegers;
        private System.Windows.Forms.Label labelPassagers;
        private System.Windows.Forms.TextBox Weight;
        private System.Windows.Forms.Label labelWeight;
        private System.Windows.Forms.TextBox Carryng;
        private System.Windows.Forms.Label labelCarrying;
        private System.Windows.Forms.CheckBox checkBoxTop;
        private System.Windows.Forms.CheckBox checkBoxBotm;
        private System.Windows.Forms.Button buttonLoc;
        private System.Windows.Forms.Button buttonHeat;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button buttonMove;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.TextBox textFuel;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.GroupBox groupGetLoc;
        private System.Windows.Forms.MaskedTextBox maskedTextBox1;
        private System.Windows.Forms.Button buttonGet;
    }
}

