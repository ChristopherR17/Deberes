# Codi de l'exercici
import utils; utils.show_code('./Ex000.py')



## Una línia entre dos punts.
#pygame.draw.line(screen, color, start_pos, end_pos, width)
#
## Un rectangle 
#pygame.draw.rect(screen, color, (x, y, width, height))
#
## Un cercle
#pygame.draw.circle(screen, GREEN, (x, y), radius)
#
## Una el·lipse dins d'un rectangle delimitador.
#pygame.draw.ellipse(screen, color, (x, y, width, height))
#
## Un arc dins d'un rectangle delimitador.
#pygame.draw.arc(screen, color, (x, y, width, height), start_angle, end_angle, width)
#
## Un polígon connectant una sèrie de punts.
#pygame.draw.polygon(screen, color, [(x1, y1), (x2, y2), (x3, y3)], width)
#
## Una sèrie de línies connectades entre diversos punts.
#pygame.draw.lines(screen, color, closed, point_list, width)