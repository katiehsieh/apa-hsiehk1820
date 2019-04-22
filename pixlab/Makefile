JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	IntArrayWorker.java \
	IntArrayWorkerTester.java \
	Pixel.java \
	Picture.java \
	SimplePicture.java \
	DigitalPicture.java \
	PictureFrame.java \
	ImageDisplay.java \
	FileChooser.java \
	PictureTester.java \
	ColorChooser.java \
	PictureExplorer.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
