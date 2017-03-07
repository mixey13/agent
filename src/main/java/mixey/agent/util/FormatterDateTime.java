package mixey.agent.util;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatterDateTime implements Formatter<LocalDateTime>{
    @Override
    public LocalDateTime parse(String s, Locale locale) throws ParseException {
        return DateTimeUtil.parseLocalDateTime(s);
    }

    @Override
    public String print(LocalDateTime dateTime, Locale locale) {
        return dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
