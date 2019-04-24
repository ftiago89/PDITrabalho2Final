import scipy.io.wavfile
import numpy as np

audioArq = open("audioSaida.txt")

sinal = []

for linha in audioArq:
    linha = linha.replace('\n', '')
    sinal.append((int)(round((float)(linha))))
    

    
sinalNp = np.array(sinal, dtype="int16")
    
scipy.io.wavfile.write("audioSaida5000deslocados.wav", 44100, sinalNp)# -*- coding: utf-8 -*-

