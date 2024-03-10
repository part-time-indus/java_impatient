package ch05.ex;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class JsonFormat extends Formatter {
    @Override
    public String format(LogRecord record){
        StringBuilder result = new StringBuilder("{").append("\n\t");
        result.append("Instant = ").append(record.getInstant()).append("\n");
        result.append("Level = ").append(record.getLevel()).append("\n");
        result.append("Class = ").append(record.getSourceClassName()).append("\n");
        result.append("Method").append(record.getSourceMethodName()).append("\n");
        result.append("}");
        return result.toString();
    }
}
