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

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

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

    for angle in range(0, 361, 15):
        pos1= utils.point_on_circle({ "x": 300, "y": 250 }, 25, angle)
        pos2 = utils.point_on_circle({ "x": 300, "y": 250 }, 150, angle)

        tupla1 = (pos1["x"], pos1["y"])
        tupla2 = (pos2["x"], pos2["y"])

        pygame.draw.line(screen, BLACK, tupla1, tupla2, 5)

    pygame.display.update()

if __name__ == "__main__":
    main()