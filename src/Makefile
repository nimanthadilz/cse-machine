JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	myrpal.java \
	main/ast/ASTReader.java \
	main/node/Node.java \
	main/node/NodeFactory.java \
	main/node/AndNode.java \
	main/node/FunctionFormNode.java \
	main/node/InfixNode.java \
	main/node/LambdaNode.java \
	main/node/LetNode.java \
	main/node/OtherNode.java \
	main/node/RecNode.java \
	main/node/WhereNode.java \
	main/node/WithinNode.java \
	main/csemachine/ControlStructure.java \
	main/csemachine/ControlStructureSet.java \
	main/csemachine/CSEMachine.java \
	main/csemachine/Environment.java \
	main/csemachine/elements/BetaElement.java \
	main/csemachine/elements/BinaryOperatorElement.java \
	main/csemachine/elements/BooleanElement.java \
	main/csemachine/elements/ControlStructureElementFactory.java \
	main/csemachine/elements/DeltaElement.java \
	main/csemachine/elements/DummyElement.java \
	main/csemachine/elements/Element.java \
	main/csemachine/elements/EnvironmentElement.java \
	main/csemachine/elements/EtaElement.java \
	main/csemachine/elements/GammaElement.java \
	main/csemachine/elements/IDElement.java \
	main/csemachine/elements/IntElement.java \
	main/csemachine/elements/LambdaElement.java \
	main/csemachine/elements/NilElement.java \
	main/csemachine/elements/StrElement.java \
	main/csemachine/elements/TauElement.java \
	main/csemachine/elements/TupleElement.java \
	main/csemachine/elements/UnaryOperatorElement.java \
	main/csemachine/elements/YElement.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) $(CLASSES:.java=.class)

