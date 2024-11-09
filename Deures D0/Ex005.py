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

    # Centre de la pantalla
    center_x, center_y = int(screen.get_width() / 2), int(screen.get_height() / 2)

    x, y = center_x, center_y
    step = 15  
    direction = 0 
    
    for _ in range(25):  
        # Calcular el punt final de la línia
        if direction == 0:  # Dreta
            end_x, end_y = x + step, y
        elif direction == 1:  # Amunt
            end_x, end_y = x, y - step
        elif direction == 2:  # Esquerra
            end_x, end_y = x - step, y
        elif direction == 3:  # Avall
            end_x, end_y = x, y + step
        
        pygame.draw.line(screen, RED, (x, y), (end_x, end_y), 4)
        
        x, y = end_x, end_y
        
        direction = (direction + 1) % 4
        step += 15  


    pygame.display.update()

if __name__ == "__main__":
    main()