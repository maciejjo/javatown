SRCDIR = src
CLASSDIR = build
JC = javac

SOURCES := $(wildcard src/*.java)
CLASSES := $(SOURCES:$(SRCDIR)/%.java=$(CLASSDIR)/%.class)

all: $(SOURCES)
	$(JC) $(SRCDIR)/*java -d $(CLASSDIR)

build/%.class: src/%.java
	$(JC) $< -d $(CLASSDIR)
