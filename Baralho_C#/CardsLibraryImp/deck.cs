/*
 * Copyright (c) 2012 Adriano Quilião de Oliveira, Douglas Almeida e Thiago Lima.
 * Este programa é licenciado pelos termos da Licença Pública Geral Menor GNU
 * em sua versão 3 e esta disponivel www.gnu.org/copyleft/lesser.txt
 */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

/// <summary>
/// Namespace da 'Library' de cartas.
/// </summary>
namespace CardsLibrary
{
    /// <summary>
    /// Classe que representa o Baralho de cartas e nesta as funções 
    /// para manipular o mesmo.
    /// </summary>
    public class Deck
    {
        private List<Card> _stack;
        private List<Card> _discardStack;

        /// <summary> Método construtor da classe Deck(Baralho). </summary>
        public Deck()
        {
            _stack = new List<Card>();
            _discardStack = new List<Card>();
            createNaipe("Copas");
            createNaipe("Espadas");
            createNaipe("Ouros");
            createNaipe("Bastos");
        }

        /// <summary>
        /// Método responsável por embaralhar as cartas.
        /// </summary>
        /// <param name="numberToExchanges">Número de trocas que devem ser feitas para embaralhar o baralho.</param>
        /// <returns></returns>
        /// <example>
        /// Exemplo de uso:
        /// <code> myDeck.shuffle(200); </code>  
        /// </example>
        public void shuffle(int numberToExchanges)
        {
            Random rand = new Random((int)DateTime.Now.Ticks);
            int size = _stack.Count();
            for (int i = 0; i <= numberToExchanges; i++)
                exchange(rand.Next(0, size), rand.Next(0, size));

        }

        /// <summary>
        /// Setar um baralho com uma lista de cartas.
        /// </summary>
        /// <param name="numberToExchanges"> Lista de Cartas. (Cards List)</param>
        /// <returns></returns>
        /// <example>
        /// Exemplo de uso:
        /// <code> myDeck.setStack(myStack); </code>  
        /// </example>
        public void setStack(List<Card> value)
        {
            _stack = value;
        }

        /// <summary>
        /// Inserir carta no baralho de descarte.
        /// </summary>
        /// <param name="card">Carta que deve ser inserida no baralho de descarte.</param>
        /// <returns></returns>
        /// <example>
        /// Exemplo de uso:
        /// <code> myDeck.discard(myCard); </code>  
        /// </example>
        public void discard(Card card)
        {
            _discardStack.Add(card);
        }

        /// <summary>
        /// Método responsável por cortar o baralho na posição definida.
        /// </summary>
        /// <param name="card">Posição em que o baralho deve ser cortado. (Max: 52 e Min: 1)</param>
        /// <returns></returns>
        /// <example>
        /// Exemplo de uso:
        /// <code> myDeck.cut(26); </code>  
        /// </example>
        public void cut(int position)
        {
            if (position < 52)
            {
                while (position-- > 0)
                    _stack.Add(this.getFistCard());
            }
        }

        /// <summary>
        /// Retorna a última carta do baralho(de baixo) e naturalmente excluí do baralho.
        /// </summary>
        /// <param></param>
        /// <returns>lastCard <see cref=”CardsLibrary.Card”/> Última carta do baralho.</returns>
        /// <example>
        /// Exemplo de uso:
        /// <code>CardsLibrary.Card myCard = myDeck.getLastCard(); </code>  
        /// </example>
        public Card getLastCard()
        {
            Card lastCard = _stack[_stack.Count() - 1];
            _stack.RemoveAt(_stack.Count() - 1);
            return lastCard;
        }

        /// <summary>
        /// Retorna a primeira carta do baralho(de cima) e naturalmente excluí do baralho.
        /// </summary>
        /// <param></param>
        /// <returns>firstCard <see cref=”CardsLibrary.Card”/> Primeira carta do baralho.</returns>
        /// <example>
        /// Exemplo de uso:
        /// <code>CardsLibrary.Card myCard = myDeck.getFirstCard(); </code>  
        /// </example>
        public Card getFistCard()
        {
            Card firstCard = _stack[0];
            _stack.RemoveAt(0);
            return firstCard;
        }

        /// <summary>
        /// Move a primeira carta(de cima) para o final do baralho(baixo).
        /// </summary>
        /// <param></param>
        /// <returns></returns>
        /// <example>
        /// Exemplo de uso:
        /// <code>myDeck.moveFirstForTheLastPosition(); </code>  
        /// </example>
        public void moveFirstForTheLastPosition()
        {
            Card firstCard = this.getFistCard();
            _stack.Add(firstCard);
        }

        /// <summary>
        /// Move a última carta(de baixo) do baralho para o inicio(cima).
        /// </summary>
        /// <param></param>
        /// <returns></returns>
        /// <example>
        /// Exemplo de uso:
        /// <code>myDeck.moveLastForTheFirstPosition(); </code>  
        /// </example>
        public void moveLastForTheFirstPosition()
        {
            Card lastCard = this.getLastCard();
            _stack.Insert(0, lastCard);
        }

        /// <summary>
        /// Retorna uma carta de uma posição específica do baralho de descarte.
        /// </summary>
        /// <param></param>
        /// <returns>card <see cref=”CardsLibrary.Card”/> Carta do baralho de descarte.</returns>
        /// <example>
        /// Exemplo de uso:
        /// <code>myDeck.getCardToDiscard(2); </code>  
        /// </example>
        public Card getCardToDiscard(int position) {
            return ((_discardStack.Count() > position && position >= 0) ? _discardStack[position] : null);
        }

        /// <summary>
        /// Retorna lista com todas as cartas do baralho de descarte.
        /// </summary>
        /// <param></param>
        /// <returns> discardStack <see cref=”system.List.CardsLibrary.Card”/> Lista com todas as cartas do baralho de descarte.</returns>
        /// <example>
        /// Exemplo de uso:
        /// <code>myDeck.getStackOfDiscard(); </code>  
        /// </example>
        public List<Card> getStackOfDiscard () {
            return _discardStack;
        }

        /// <summary>
        /// Retorna lista com todas as cartas do baralho de descarte e apaga o descarte.
        /// </summary>
        /// <param></param>
        /// <returns> discardStack <see cref=”system.List.CardsLibrary.Card”/> Lista com todas as cartas do baralho de descarte.</returns>
        /// <example>
        /// Exemplo de uso:
        /// <code>myDeck.clearDiscard(); </code>  
        /// </example>
        public List<Card> clearDiscard()
        {
            List<Card> tmpDiscard = _discardStack;
            _discardStack = new List<Card>();
            return tmpDiscard;
        }


        /// <summary>
        /// Método Privado:
        /// Método responsável por criar naipe de cartas.
        /// </summary>
        private void createNaipe(string name)
        {

            for (int i = 1; i <= 13; i++)
            {
                Card newCard = new Card();
                newCard.index = i;
                newCard.naipe = name;
                _stack.Add(newCard);
            }

        }


        /// <summary>
        /// Calcula a quantidade de Cartas que estão no baralho e retorna.
        /// </summary>
        /// <param></param>
        /// <returns> A quantidade de cartas presentes no baralho. (INT)</returns>
        /// <example>
        /// Exemplo de uso:
        /// <code> myDeck.count(); </code>  
        /// </example>
        public int count()
        {
            return _stack.Count();
        }



        /// <summary>
        /// Método Privado:
        /// Troca cartas do baralho do endereço a para o b e vice-versa.
        /// </summary>
        private void exchange(int a, int b)
        {
            Card cardBuff = _stack[a];
            _stack[a] = _stack[b];
            _stack[b] = cardBuff;
        }

        /// <summary>
        /// Método Público:
        /// Implementação do Iterator(Design Pattern) da classe deck, 
        /// responsável por percorrer baralho retornando uma por uma das cartas.
        /// <example>
        /// Exemplo de uso:
        /// <code>
        /// foreach (CardsLibrary.Card card in deck)
        ///     Console.WriteLine("Naipe -> " + card.naipe + "  Carta -> " + card.index.ToString());
        /// </code>  
        /// </example>
        public System.Collections.IEnumerator GetEnumerator()
        {
            for (int i = 0; i < _stack.Count(); i++)
                yield return _stack[i];
        }

    }
}
