/*
 * Copyright (c) 2012 Adriano Quilião de Oliveira, Douglas Almeida e Thiago Lima.
 * Este programa é licenciado pelos termos da Licença Pública Geral Menor GNU
 * em sua versão 3 e esta disponivel www.gnu.org/copyleft/lesser.txt
 */
using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace testCards
{
    /// <summary>
    /// Summary description for UnitTest1
    /// </summary>
    [TestClass]
    public class UnitTest1
    {
        private CardsLibrary.Deck baralho;

        public UnitTest1()
        {
            //
            // TODO: Add constructor logic here
            //
            this.baralho = new CardsLibrary.Deck();

        }

        private TestContext testContextInstance;

        /// <summary>
        ///Gets or sets the test context which provides
        ///information about and functionality for the current test run.
        ///</summary>
        public TestContext TestContext
        {
            get
            {
                return testContextInstance;
            }
            set
            {
                testContextInstance = value;
            }
        }

        #region Additional test attributes
        //
        // You can use the following additional attributes as you write your tests:
        //
        // Use ClassInitialize to run code before running the first test in the class
        // [ClassInitialize()]
        // public static void MyClassInitialize(TestContext testContext) { }
        //
        // Use ClassCleanup to run code after all tests in a class have run
        // [ClassCleanup()]
        // public static void MyClassCleanup() { }
        //
        // Use TestInitialize to run code before running each test 
        // [TestInitialize()]
        // public void MyTestInitialize() { }
        //
        // Use TestCleanup to run code after each test has run
        // [TestCleanup()]
        // public void MyTestCleanup() { }
        //
        #endregion

        [TestMethod]
        public void TestMethod1()
        {
            //
            // TODO: Add test logic	here
            //
            
            /* Analisando construtor */
            Assert.IsInstanceOfType(new CardsLibrary.Deck(), typeof(CardsLibrary.Deck), "Problemas no método construtor.");
            
            /* Verificando o tipo de retorno do método que retorna a quantidade de cartas */
            Assert.IsInstanceOfType(this.baralho.count(), typeof(int), "Tipo invalido de dado no método que conta a quantidade de cartas do baralho.");
            
            /* Verificar a quantidade de cartas do baralho */ 
            Assert.AreEqual(52, this.baralho.count(), "O número de cartas do baralho está incorreto.");
            
            /* Verificar o método de embaralhar */
            this.baralho.shuffle(1000);
            Assert.AreEqual(52, this.baralho.count(), "O método de embaralhar está removendo ou incluindo alguma carta.");

            /* Verificar o método de cortar o baralho */
            this.baralho.cut(20);
            Assert.AreEqual(52, this.baralho.count(), "O método de cortar o baralho está removendo ou inserindo alguma carta.");

            /* Verificar o método de mover a primeira carta para a ultima posição */
            this.baralho.moveFirstForTheLastPosition();
            Assert.AreEqual(52, this.baralho.count(), "O método de mover a primeira carta para a ultima posição do baralho está removendo ou inserindo alguma carta.");

            /* Verificar o método de mover a ultima carta para a primeira posição */
            this.baralho.moveLastForTheFirstPosition();
            Assert.AreEqual(52, this.baralho.count(), "O método de mover a ultima carta para a primeira posição do baralho está removendo ou inserindo alguma carta.");

            /* Verificando o tipo de retorno quando solicitada uma carta */
            Assert.IsInstanceOfType(this.baralho.getFistCard(), typeof(CardsLibrary.Card), "O método getFistCard não retorna um objeto do tipo carta.");  
            Assert.IsInstanceOfType(this.baralho.getLastCard(), typeof(CardsLibrary.Card), "O método getFistCard não retorna um objeto do tipo carta.");
            
            /*Verificando se quando solicitada uma carta ela é realmente removida */
            Assert.AreNotEqual(new CardsLibrary.Deck(), this.baralho, "Baralho não está removendo cartas quando solicitado.");
            
            /*Verificando métodos de descarte da biblioteca */
            this.baralho.discard(this.baralho.getFistCard());
            Assert.IsInstanceOfType(this.baralho.getStackOfDiscard(), typeof(List<CardsLibrary.Card>), "Não estão funcionando os métodos de descarte da biblioteca.");

            /*Verificando a limepeza do monte de descarte */
            this.baralho.clearDiscard();
            Assert.AreEqual(0, this.baralho.getStackOfDiscard().Count(), "Método para limpar o descarte não está funcionando.");

            /*Verificando métodos de retornar uma carta do descarte */
            this.baralho.discard(this.baralho.getFistCard());
            Assert.IsInstanceOfType(this.baralho.getCardToDiscard(0), typeof(CardsLibrary.Card), "O método responsável por retornar uma carta do descarte não está retornando um objeto do tipo Carta.");
           
        }
    }
}
