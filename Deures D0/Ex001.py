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

    pygame.draw.rect(screen, RED, (50, 50, 550, 100))
    font1 = pygame.font.SysFont("Arial", 60)
    text = font1.render('HEADLINE NEWS', True, WHITE)
    screen.blit(text, (75, 70))

    font2 = pygame.font.SysFont("Courier New", 40, "Bold")
    text2 = font2.render("World goes Wrong!", True, BLACK)
    screen.blit(text2, (50, 160))

    text3 = font2.render("YEP#", True, (100,150,100))
    screen.blit(text3, (510, 155))

    font3 = pygame.font.SysFont("Arial", 28)
    text4 = font3.render("Lorem ipsum dolor sit amet, consectetur", True, BLACK)
    screen.blit(text4, (50, 245))

    text5 = font3.render("adipiscing elit, sed do eiusmod tempor", True, BLACK)
    screen.blit(text5, (50, 285))

    text6 = font3.render("incididunt ut labore et dolore magna aliqua.", True, BLACK)
    screen.blit(text6, (50, 320))

    pygame.display.update()

if __name__ == "__main__":
    main()