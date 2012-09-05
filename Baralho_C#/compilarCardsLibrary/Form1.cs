/*
 * Copyright (c) 2012 Adriano Quilião de Oliveira, Douglas Almeida e Thiago Lima.
 * Este programa é licenciado pelos termos da Licença Pública Geral Menor GNU
 * em sua versão 3 e esta disponivel www.gnu.org/copyleft/lesser.txt
 */
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

    public partial class Form1 : Form
    {
        CardsLibrary.Deck baralho;
        Form2 manual;

        public Form1()
        {
            InitializeComponent();
            this.inicializarJogo();
        }

        private void inicializarJogo(){

            this.baralho = new CardsLibrary.Deck();
            this.lb_carta_comp.Text = ". . .";
            this.lb_carta_jog.Text = ". . .";
            this.lb_cartas_jogador.Text = "26";
            this.lb_cartas_comp.Text = "26";
            this.lb_pontuacao_jogador.Text = "0";
            this.lb_pontuacao_comp.Text = "0";
            this.baralho.shuffle(500);

        }

        private void bt_proxima_Click(object sender, EventArgs e)
        {

            if (this.baralho.count() == 0)
            {
                if (this.baralho.getStackOfDiscard().Count() > 0)
                {
                    int discardCount = this.baralho.getStackOfDiscard().Count();
                    this.baralho.clearDiscard();
                    MessageBox.Show("Foram armazenadas no descarte " + discardCount.ToString() + " cartas. \nobs: Descarte limpo.");
                }
                if (Convert.ToInt32(this.lb_pontuacao_jogador.Text) > Convert.ToInt32(this.lb_pontuacao_comp.Text))
                    MessageBox.Show("Você ganhou o jogo ! ! !");
                else if (Convert.ToInt32(this.lb_pontuacao_jogador.Text) < Convert.ToInt32(this.lb_pontuacao_comp.Text))
                    MessageBox.Show("Você perdeu.");
                else
                    MessageBox.Show("O jogo acabou empatado");
            }
            else
            {
                CardsLibrary.Card cartaJogador = this.baralho.getFistCard();
                this.lb_carta_jog.Text = cartaJogador.index.ToString() + " de " + cartaJogador.naipe;
                CardsLibrary.Card cartaMaquina = this.baralho.getFistCard();
                this.lb_carta_comp.Text = cartaMaquina.index.ToString() + " de " + cartaMaquina.naipe;
                this.lb_cartas_jogador.Text = (Convert.ToInt32(this.lb_cartas_jogador.Text) - 1).ToString();
                this.lb_cartas_comp.Text = (Convert.ToInt32(this.lb_cartas_comp.Text) - 1).ToString();
                if (cartaJogador.index > cartaMaquina.index)
                    this.lb_pontuacao_jogador.Text = (Convert.ToInt32(this.lb_pontuacao_jogador.Text) + 1).ToString();
                else if (cartaJogador.index < cartaMaquina.index)
                    this.lb_pontuacao_comp.Text = (Convert.ToInt32(this.lb_pontuacao_comp.Text) + 1).ToString();
                else
                {
                    this.baralho.discard(cartaJogador);
                    this.baralho.discard(cartaMaquina);
                }

            }

         }

        private void manualToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.inicializarJogo();
        }

        private void sairToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void sairToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (this.manual != null)
            {
                this.manual.Close();
                this.manual = null;
            }
            this.manual = new Form2();
            this.manual.Show();
            
        }
    }
}
