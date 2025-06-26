#!/bin/bash

echo "📦 Compilazione in corso..."

# Crea la cartella bin se non esiste
mkdir -p bin

# Compila tutti i file .java, sovrascrivendo i .class in bin/
javac -d bin *.java

# Controlla che la compilazione sia andata a buon fine
if [ $? -eq 0 ]; then
    echo "✅ Compilazione completata. Avvio del programma..."
    java -cp bin Main
else
    echo "❌ Errore durante la compilazione."
fi
