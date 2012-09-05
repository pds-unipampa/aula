namespace compilarCardsLibrary
{
    partial class Form2
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
            this.lb_manual = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.lb_comojogar = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.lb_exemplo = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // lb_manual
            // 
            this.lb_manual.AutoSize = true;
            this.lb_manual.Location = new System.Drawing.Point(22, 44);
            this.lb_manual.Name = "lb_manual";
            this.lb_manual.Size = new System.Drawing.Size(25, 13);
            this.lb_manual.TabIndex = 0;
            this.lb_manual.Text = ". . . ";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(19, 30);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(68, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "Descrição:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(19, 144);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(74, 13);
            this.label2.TabIndex = 3;
            this.label2.Text = "Como jogar:";
            // 
            // lb_comojogar
            // 
            this.lb_comojogar.AutoSize = true;
            this.lb_comojogar.Location = new System.Drawing.Point(25, 157);
            this.lb_comojogar.Name = "lb_comojogar";
            this.lb_comojogar.Size = new System.Drawing.Size(25, 13);
            this.lb_comojogar.TabIndex = 2;
            this.lb_comojogar.Text = ". . . ";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(19, 88);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(58, 13);
            this.label3.TabIndex = 5;
            this.label3.Text = "Exemplo:";
            // 
            // lb_exemplo
            // 
            this.lb_exemplo.AutoSize = true;
            this.lb_exemplo.Location = new System.Drawing.Point(22, 102);
            this.lb_exemplo.Name = "lb_exemplo";
            this.lb_exemplo.Size = new System.Drawing.Size(25, 13);
            this.lb_exemplo.TabIndex = 4;
            this.lb_exemplo.Text = ". . . ";
            // 
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(481, 230);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.lb_exemplo);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.lb_comojogar);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.lb_manual);
            this.Name = "Form2";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Manual do Jogo";
            this.Load += new System.EventHandler(this.Form2_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lb_manual;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label lb_comojogar;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label lb_exemplo;
    }
}