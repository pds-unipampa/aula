project(Somador)

cmake_minimum_required(VERSION 2.8)


include(CPack)

add_library(Soma SHARED arquivo.c)

add_executable(somador main.c)

target_link_libraries(somador Soma)




install (
	 TARGETS Soma #Nome do alvo que vai ser instalado (aqui é a biblioteca
	 #Onde os componentes de tempo de execução devem ser instaldos? (aqui indica uma pasta atual)
         RUNTIME DESTINATION .
         #Pode ser usado para instalar apenas parte (componentes) do software
	 COMPONENT somaLibs
	 #Onde as bibliotecas devem ser instaladas?
         LIBRARY DESTINATION . 
         #Onde os demais arquivos devem ser instalados?
         ARCHIVE DESTINATION .
)


install (#Nome do alvo que vai ser instalado (aqui é a applicação)
	 TARGETS somador 
	 #Onde os componentes de tempo de execução devem ser instaldos? (aqui indica uma pasta atual)
         RUNTIME DESTINATION . 
         #Pode ser usado para instalar apenas parte (componentes) do software
	 COMPONENT somaApps
	 #Onde as bibliotecas devem ser instaladas?
         LIBRARY DESTINATION . 
         #Onde os demais arquivos devem ser instalados?
         ARCHIVE DESTINATION .
)



ENABLE_TESTING()

add_executable(somador_test test_main.c)

target_link_libraries(somador_test Soma)

add_test(TestSomador somador_test)