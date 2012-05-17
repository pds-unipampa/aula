project(Deck_Handling_Library)

add_library(libDeckHandling SHARED deckHandling.c)

add_executable(Manipulador_de_baralho mainDeckHandling.c)

target_link_libraries(Manipulador_de_baralho libDeckHandling)
