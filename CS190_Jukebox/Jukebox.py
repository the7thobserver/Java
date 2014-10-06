import pygame

class Commands:
    def __init__(self):
        pygame.mixer.init(frequency=48000, size=16, channels=2, buffer=4096)
        
    def load(self,filename):
        pygame.mixer.music.load(filename)
    
    def play(self,loops = 0, pos = 0.0):
        pygame.mixer.music.play(loops,pos)

    def stop(self):
        pygame.mixer.music.stop()
        
    def pause(self):
        pygame.mixer.music.pause()
    
    def unpause(self):
        pygame.mixer.music.unpause()
    
    def queue(self,file):
        pygame.mixer.music.queue(file)

c = Commands()

i = 0  
song1 = 'BabaYetu.ogg'
song2 = 'Benny Benassi - Bring the Noise.ogg'
song3 = 'ChuckBerry.ogg'
song4 = 'BackInBlack.ogg'
song5 = 'LoveIsGone.ogg'


PLAYLIST = [song1,song2,song3,song4,song5]
c.load(PLAYLIST[i])
c.play()

while True:
    
    x = input('Next, Back, Stop, Pause, Unpause, Queue, Quit:')
    if x == 'Quit':
        break
    if x == 'Stop':
        c.stop()
    if x == 'Pause':
        c.pause()
    if x == 'Unpause':
        c.unpause()    
    
    if x == 'Next':
        try:
            i += 1
            c.load(PLAYLIST[i])
        except IndexError:
            i = 0
            c.load(PLAYLIST[i])
        c.play()
        
    if x == 'Back':
        try:
            i -= 1
            c.load(PLAYLIST[i])
        except IndexError:
            i = -1
            c.load(PLAYLIST[i])
        c.play()
        
    if x == 'Queue':
        try:
            i += 1
            c.queue(PLAYLIST[i])
        except IndexError:
            i = 0
            c.queue(PLAYLIST[i])
        print(PLAYLIST[i],'has been added to playlist')
        
    

