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
GRAY = (200, 200, 200)
PINK = (255, 105, 180)
GREEN = (0, 255, 0)
BLUE = (0, 0, 255)
RED = (255, 0, 0)

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480), pygame.RESIZABLE)
pygame.display.set_caption('Window Title')

# Variables de l'estat del ratolí
mouse_pos = { "x": -1, "y": -1 }
mouse_down = False
square_dragging = False
circle_dragging = False
drag_offset = { "x": 0, "y": 0 }

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
    mouse_inside = pygame.mouse.get_focused()

    for event in pygame.event.get():
        if event.type == pygame.QUIT: # Botó tancar finestra
            return False
        elif event.type == pygame.MOUSEMOTION:
            if mouse_inside:
                mouse_pos["x"] = event.pos[0]
                mouse_pos["y"] = event.pos[1]
            else:
                mouse_pos["x"] = -1
                mouse_pos["y"] = -1
    return True

# Fer càlculs
def app_run():
    global mouse_pos

# Dibuixar
def app_draw():
    screen.fill(WHITE)
    utils.draw_grid(pygame, screen, 50)

    pygame.draw.rect(screen, BLACK, (50,50,550,400), 5)
    pygame.draw.line(screen, BLACK, (0,250),(650,250), 5)
    pygame.draw.line(screen, BLACK, (325,0),(325,500), 5)

    pygame.draw.rect

    pygame.display.update()

if __name__ == "__main__":
    main()