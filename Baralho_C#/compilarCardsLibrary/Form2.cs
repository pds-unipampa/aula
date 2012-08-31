using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace compilarCardsLibrary
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            this.lb_manual.Text  = "O jogador joga contra o computador e o que conseguir somar mais pontos ";
            this.lb_manual.Text += "é o vencedor.\n";
            this.lb_manual.Text += "Para pontuar o jogador deve ter uma carta de valor superior ao da recebida pelo computador.";

            this.lb_exemplo.Text = "Se o Jogador tem um 10 de copas e a maquina um 2 de ouro, o ponto é do jogador.";

            this.lb_comojogar.Text  = "Clicando no botão próxima carta os duelos entre o proponente e a máquina\n";
            this.lb_comojogar.Text += "é travado até finalizar todas as cartas do baralho.";
        }


    }
}
