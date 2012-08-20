project(Trabalho1)

add_library(baralho SHARED baralho.c) # gera a biblioteca libBaralho

add_executable(exec main.c) # arquivos necessários para criar o executável

target_link_libraries(exec baralho) 


