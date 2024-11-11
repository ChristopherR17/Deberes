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
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

Arial = pygame.font.SysFont("Arial", 15)

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

    pygame.draw.circle(screen, BLUE, (100,50), 5)
    draw_text("Poma", Arial, 100, 50, "left", "bottom")

    pygame.draw.circle(screen, BLUE, (100,100), 5)
    draw_text("Pera", Arial, 100, 100, "center", "center")

    pygame.draw.circle(screen, BLUE, (100,150), 5)
    draw_text("Raim", Arial, 100, 150, "right", "top")

    pygame.draw.circle(screen, BLUE, (250,50), 5)
    draw_text("Platan", Arial, 250, 50, "left", "top")

    pygame.draw.circle(screen, BLUE, (250,100), 5)
    draw_text("Presec", Arial, 250, 100, "center", "center")

    pygame.draw.circle(screen, BLUE, (250,150), 5)
    draw_text("Maduixa", Arial, 250, 150, "right", "bottom")

    pygame.display.update()

def draw_text(text, font, x, y, align_x="left", align_y="top"):
    text_surface = font.render(text, True, BLACK)
    text_rect = text_surface.get_rect()
    
    if align_x=="center":
        text_rect.centerx = x
    elif align_x=="right":
        text_rect.right = x
    else:
        text_rect.left = x

    if align_y=="center":
        text_rect.centery = y
    elif align_y=="bottom":
        text_rect.bottom = y
    else:
        text_rect.top = y

    screen.blit(text_surface, text_rect)
    pygame.draw.line(screen, (0, 0, 0), (x, y), (x + 50, y), 1)


if __name__ == "__main__":
    main()