#!/usr/bin/python

import sys
from PyQt4 import QtGui, QtCore
from PyQt4.QtGui import QTableWidget

class MusicPlayerUI(QtGui.QMainWindow):
    
    def __init__(self):
        super(MusicPlayerUI, self).__init__()        
        self.initUI()
        
    def initUI(self):               

        exitAction = QtGui.QAction('Exit', self)
        exitAction.setShortcut('Ctrl+Q')
        exitAction.setStatusTip('Exit application')
        exitAction.triggered.connect(self.close)

#         infoAction = QtGui.q
#         infoAction.triggered.connect()
        
        menubar = self.menuBar()
        fileMenu = menubar.addMenu('File')
        fileMenu.addAction(exitAction)
        fileMenu = menubar.addMenu('Help');
#         fileMenu.addAction(infoAction)
        
        # toolbar = self.addToolBar('Exit')
        # toolbar.addAction(exitAction)
        
        # Button
#         redb = QtGui.QPushButton('Play', self)
#         redb.move(10, 22)
        
        # Slider
        sld = QtGui.QSlider(QtCore.Qt.Horizontal, self)
        # Do not accept keyboard shortcuts to focus
        sld.setFocusPolicy(QtCore.Qt.NoFocus)
        # Initial X, Initial Y, Width, Height
        sld.setGeometry(10, 210, 500, 15)
        sld.valueChanged[int].connect(self.updateSlider)
        
        # Table of songs
        table = QTableWidget(self)
        table.setColumnCount(4)
        table.setRowCount(4)
        table.setHorizontalHeaderLabels(['Title', 'Artist', 'Album', 'Year'])
        table.move(10, 30)
        table.resize(580, 170)
        table.setColumnWidth(0, 250)
        table.setColumnWidth(1, 130)
        table.setColumnWidth(2, 120)
        table.setColumnWidth(3, 60)
        
        # Play
        self.playb = QtGui.QLabel(self)
        # Todo: Change icon
        self.playb.setPixmap(QtGui.QPixmap('D:\Documents\Pictures\L.jpg'))
        self.playb.setGeometry(15, 235, 40, 40)
        self.playb.setScaledContents(True)
        self.connect(self.playb, QtCore.SIGNAL("clicked()"), self.play)
        self.playb.pressed.connect(self.play)
        
        # Pause
        self.label = QtGui.QLabel(self)
        # Todo: Change icon
        self.label.setPixmap(QtGui.QPixmap('D:\Documents\Pictures\L.jpg'))
        self.label.setGeometry(65, 235, 40, 40)
        self.label.setScaledContents(True)
        
        # Timer
        self.timer = QtGui.QLabel(self)
        # Todo: Change icon
        self.timer.setText("00:00")
        self.timer.setStyleSheet("font: 15pt;")
        self.timer.setGeometry(520, 195, 60, 40)
        self.timer.setScaledContents(True)
        
        # Initial X, Initial Y, Width, Height
        self.setGeometry(100, 100, 600, 300)
        self.setWindowTitle('Music Player')
        # Todo: Change icon path
        self.setWindowIcon(QtGui.QIcon('D:\Documents\Pictures\L.jpg'))           
        self.show()
        
    def updateSlider(self, value):
        self.timer.setText(str(value))
        
    def play(self):
        print("Play")
        print("AAAA")
        
def main():
    
    app = QtGui.QApplication(sys.argv)
    player = MusicPlayerUI()
    sys.exit(app.exec_())


if __name__ == '__main__':
    main()    