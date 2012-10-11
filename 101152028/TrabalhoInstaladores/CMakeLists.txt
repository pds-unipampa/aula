# file CMakeLists.txt
 
# esta primeira linha não é obrigatória. Mas o CMake às vezes reclama da ausência dela
cmake_minimum_required(VERSION 2.6)

include(CPack)

# definição do nome do project. Não precisa ser obrigatoriamente o nome do diretório
project(Baralho)


# a palavra STATIC pode ser colocada depois do nome da biblioteca, mas é opcional
add_library(BBaralho SHARED baralho.c)
 
# adicionando o nome 
add_executable(app main.c)

target_link_libraries(app BBaralho)


install (
	 TARGETS BBaralho #Nome do alvo que vai ser instalado (aqui é a biblioteca)
	 #Onde os componentes de tempo de execução devem ser instaldos? (aqui indica uma pasta atual)
         RUNTIME DESTINATION bin
         #Pode ser usado para instalar apenas parte (componentes) do software
	 COMPONENT somaLibs
	 #Onde as bibliotecas devem ser instaladas?
         LIBRARY DESTINATION lib 
         #Onde os demais arquivos devem ser instalados?
         ARCHIVE DESTINATION lib
)


install (
	 TARGETS app  #Nome do alvo que vai ser instalado (aqui é a applicação) 
	 #Onde os componentes de tempo de execução devem ser instaldos? (aqui indica uma pasta atual)
         RUNTIME DESTINATION bin 
         #Pode ser usado para instalar apenas parte (componentes) do software
	 COMPONENT somaApps
	 #Onde as bibliotecas devem ser instaladas?
         LIBRARY DESTINATION lib 
         #Onde os demais arquivos devem ser instalados?
         ARCHIVE DESTINATION lib
)