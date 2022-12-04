JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Main.java \
	src/main/node/Node.java \
	src/main/node/NodeFactory.java \
	src/main/node/AndNode.java \
	src/main/node/FunctionFormNode.java \
	src/main/node/InfixNode.java \
	src/main/node/LambdaNode.java \
	src/main/node/LetNode.java \
	src/main/node/OtherNode.java \
	src/main/node/RecNode.java \
	src/main/node/WhereNode.java \
	src/main/node/WithinNode.java \
	src/main/csemachine/Controlstructure.java \
	src/main/csemachine/ControlstructureSet.java \
	src/main/csemachine/CSEMachine.java \
	src/main/csemachine/Environment.java \
	src/main/csemachine/elements/BetaElement.java \
	src/main/csemachine/elements/BinaryOperatorElement.java \
	src/main/csemachine/elements/BooleanElement.java \
	src/main/csemachine/elements/ControlStructureElement.java \
	src/main/csemachine/elements/DeltaElement.java \
	src/main/csemachine/elements/DummyElement.java \
	src/main/csemachine/elements/Element.java \
	src/main/csemachine/elements/EnvironmentElement.java \
	src/main/csemachine/elements/EtaElement.java \
	src/main/csemachine/elements/GammaElement.java \
	src/main/csemachine/elements/IDElement.java \
	src/main/csemachine/elements/IntElement.java \
	src/main/csemachine/elements/LambdaElement.java \
	src/main/csemachine/elements/NilElement.java \
	src/main/csemachine/elements/StrElement.java \
	src/main/csemachine/elements/TauElement.java \
	src/main/csemachine/elements/TupleElement.java \
	src/main/csemachine/elements/UnaryElement.java \
	src/main/csemachine/elements/YElement.java \
	src/main/csemachine/elements/YElement.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

