#!/usr/bin/env python3

import math
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils

# Definir colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
GREEN = (100, 150, 100)
RED = (200, 0, 0)
BLUE = (50, 120, 200)

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

dades = [ 
  {'nom': 'Pelut', 'any': 2018, 'pes': 6.5, 'especie': 'Gos'},
  {'nom': 'Pelat', 'any': 2020, 'pes': 5.0, 'especie': 'Gos'},
  {'nom': 'Mia', 'any': 2022, 'pes': 3.0, 'especie': 'Gat'},
  {'nom': 'Nemo', 'any': 2003, 'pes': 0.1, 'especie': 'Peix'},
  {'nom': 'Mickey', 'any': 1928, 'pes': 0.5, 'especie': 'Ratolí'},
  {'nom': 'Donald', 'any': 1934, 'pes': 0.5, 'especie': 'Ànec'} 
]

# Bucle de l'aplicació
def main():
    is_looping = True

    while is_looping:
        is_looping = app_events()
        app_run()
        app_draw()

        clock.tick(60) # Limitar a 60 FPS

    # Fora del bucle, tancar l'aplicació
    pygame.quit()
    sys.exit()

# Gestionar events
def app_events():
    for event in pygame.event.get():
        if event.type == pygame.QUIT: # Botó tancar finestra
            return False
    return True

# Fer càlculs
def app_run():
    pass

# Dibuixar
def app_draw():
    screen.fill(WHITE)
    utils.draw_grid(pygame, screen, 50)

    #Fons Blanc
    pygame.draw.rect(screen, WHITE, (150, 100, 200, 150))
    
    #Linies
    y = 100
    for i in range(7):
        pygame.draw.line(screen, BLACK, (150, y), (350, y), 3)
        y += 25

    #Noms
    font1 = pygame.font.SysFont("Arial", 18)

    #Detalls
    font2 = pygame.font.SysFont("Arial", 16)

    #Print
    y2 = 102
    for row in range(len(dades)):
        text1 = font1.render(dades[row]['nom'], True, BLACK)
        screen.blit(text1, (155, y2))

        text2 = font2.render(str(dades[row]['any']), True, BLUE)
        screen.blit(text2, (255, y2))
        
        text3 = font2.render(dades[row]['especie'], True, BLUE)
        screen.blit(text3, (305, y2))
        y2 += 25

    pygame.display.update()

if __name__ == "__main__":
    main()