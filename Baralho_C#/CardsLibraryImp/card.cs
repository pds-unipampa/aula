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
    /// Classe que representa a carta e tem todos os atributos referentes a mesma bem como os métodos
    /// utilizados para setar os seus valores.
    /// </summary>
    public class Card
    {
        private int _index;
        private string _fileName;
        private string _naipe;

        /// <summary>
        /// Obter ou setar o valor da variável index(que representa o indice). 
        /// </summary>
        /// <value>Representa o valor da carta e vai de 1 até 13.</value>
        /// <remarks> O valor é do tipo inteiro.</remarks>
        public int index
        {
            get
            {
                return _index;
            }
            set
            {
                _index = value;
            }
        }

        /// <summary>
        /// Obter ou setar o valor da variável fileName(caminho e nome do arquivo). 
        /// </summary>
        /// <value>Representado como string esta deve conter o caminho e o nome da imagem que representa a foto.</value>
        /// <remarks> O valor é do tipo string.</remarks>
        public string fileName 
        {
            get {
                return _fileName; 
            }
            set {
                _fileName = @value;        
            }
        }

        /// <summary>
        /// Obter ou setar o valor da variável naipe(naipe/grupo da carta). 
        /// </summary>
        /// <value>Representado o naipe da carta.</value>
        /// <remarks> O valor é do tipo string.</remarks>
        public string naipe
        {
            get
            {
                return _naipe;
            }
            set
            {
                _naipe = value;
            }
        }

    }
}
