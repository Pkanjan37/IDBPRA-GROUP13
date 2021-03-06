package org.zavodnikov.antlr.Hello;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
public class DescriptiveErrorListener extends BaseErrorListener {
	private static final boolean REPORT_SYNTAX_ERRORS = true;
    public static DescriptiveErrorListener INSTANCE = new DescriptiveErrorListener();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e)
    {
    	 if (!REPORT_SYNTAX_ERRORS) {
    	        return;
    	    }


        String sourceName = recognizer.getInputStream().getSourceName();
        if (!sourceName.isEmpty()) {
            sourceName = String.format("%s:%d:%d: ", sourceName, line, charPositionInLine);
        }

        System.err.println(sourceName+"line "+line+":"+charPositionInLine+" "+msg+" testo");
    }
}