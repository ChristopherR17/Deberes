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

    center = { "x": 300, "y": 250 }

    for angle in range(0, 361, 15):

        saturation = 1
        lightness = 0.5
        color = utils.hsl_to_rgb(angle, saturation, lightness)

        pos1= utils.point_on_circle(center, 25, angle)
        pos2 = utils.point_on_circle(center , 150, angle)

        prev_angle = (angle-15)

        prev1= utils.point_on_circle(center, 25, prev_angle)
        prev2 = utils.point_on_circle(center , 150, prev_angle)

        punts = [
            (int(pos1["x"]), int(pos1["y"])),
            (int(pos2["x"]), int(pos2["y"])),
            (int(prev2["x"]), int(prev2["y"])),
            (int(prev1["x"]), int(prev1["y"]))
        ]

        pygame.draw.polygon(screen, color, punts)

    pygame.display.update()

if __name__ == "__main__":
    main()