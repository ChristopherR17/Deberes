#!/usr/bin/env python3

import random
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils
from assets.svgmoji.emojis import get_emoji

# Definir colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

# Dades del cotxe
path = os.path.join(os.path.dirname(__file__), "./assets/exercici013/car.png")
img_car = pygame.image.load(path).convert_alpha()
img_car = utils.scale_image(pygame, img_car, target_width=15)

path = os.path.join(os.path.dirname(__file__), "./assets/exercici013/circuit.png")
img_circuit = pygame.image.load(path).convert_alpha()
img_circuit = utils.scale_image(pygame, img_circuit, target_height=480)

car = {
    "x": 245,
    "y": 430,
    "angle": 90,
    "speed": 100,
    "img": img_car,
    "direction_x": "none",
    "direction_y": "none",
}

# Bucle de l'aplicació
def main():
    is_looping = True

    while is_looping:
        is_looping = app_events()
        app_run()
        app_draw()

        clock.tick(60) # Limitar a 60 FPS

    pygame.quit()
    sys.exit()

# Gestionar events
def app_events():
    global car

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

    for counter in range(11):
        light = counter * (255 / 10)
        x = 50 + (counter * 50)
        
        pygame.draw.rect(screen, (light,0,0), (x,150,50,50))
        pygame.draw.rect(screen, (0,light,0), (x,200,50,50))
        pygame.draw.rect(screen, (0,0,light), (x,250,50,50))
        pygame.draw.rect(screen, (light,light,light), (x,300,50,50))

    pygame.display.update()

if __name__ == "__main__":
    main()
