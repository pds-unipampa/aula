Este trabalho trata-se de uma implementação de uma biblioteca que simula um baralho de 52 cartas. Apresenta ainda algumas funções, como cortar o baralho, comprar uma carta, descartar uma carta, etc.




Documentação:

Utilizando a GUI do doxygen.
Acessando pelo terminal: digitar "doxywizard"
Se preciso instalar a GUI, digitar "sudo apt-get install doxygen-gui"

Na primeira tela que aparece, em Step 1, informar o diretório de onde o doxygen irá rodar. Pode ser a pasta onde irá gerar a documentação, a mesma onde estão os arquivos .c e .h.

No tópico Project:
Preenchar "Project name", "Source code directory" e "Destination directory". Informar o diretório onde encontran-se os arquivos do projeto, os .c e o .h.
Clicar em "Next".

No tópico Mode:
Marcar "Optmize for C or PHP".
Clicar em "Next".

No tópico "Output":
Clicar em "Next".

Após, clicar na aba "Expert", tópico "Input":
No campo INPUT_ENCODING, tive que mudar para ISO-8859-1, mas UTF-* deve funcionar.

Clicar na aba "Run":
Clicar no botão "Run doxygen".

Pronto. A documentação deve estar pronta e pode ser acessada na de destino informada em "Destination directory".




Construção:

Utilizando o CMAKE (http://www.cmake.org/) acessar via terminal o diretório onde estão salvos os arquivos do projeto e o arquivo CMakeLists.txt que acompanha.
Então, digitar os seguintes comandos "cmake ." e logo após "make":
cmake . -> o CMAKE gera os arquivos de construção
make -> executa a compilação


