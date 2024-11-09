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
    global colors
    is_looping = True

    colors = [(127, 184, 68), (240, 187, 64), (226, 137, 50), (202, 73, 65), (135, 65, 152), (75, 154, 217)]

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

    x = 50
    x2 = 75
    
    for q in range(0,len(colors)):
        #Quadrats
        pygame.draw.rect(screen, colors[q], (x, 50, 50, 50))
        x += 100
        #Cercles
        pygame.draw.circle(screen, colors[q], (x2, 175), 25, 2)
        x2 += 100
    
    grisos = 0
    for q in range (0, 10):
        radius = 25
        x = 50 + (q * 100) + radius
        color = (grisos, grisos, grisos)
        draw_polygon(screen, color, (x, 250 + radius), radius, 3)
        draw_polygon(screen, color, (x, 350 + radius), radius, 5)
        grisos += 25
        

    pygame.display.update()

#Funció per dibuixar els triangles i pentàgons
def draw_polygon(screen, color, center, radius, num_vertices, angle_offset=(math.pi / 3)):
    points = [
        (
            center[0] + radius * math.cos(angle_offset + i * 2 * math.pi / num_vertices),
            center[1] + radius * math.sin(angle_offset + i * 2 * math.pi / num_vertices)
        )
        for i in range(num_vertices)
    ]
    pygame.draw.polygon(screen, color, points)

if __name__ == "__main__":
    main()