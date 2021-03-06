package org.bukkit.craftbukkit.v1_5_R2.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import net.minecraft.server.MinecraftServer;
//import joptsimple.OptionException;
//import joptsimple.OptionSet;
/**
 * 
 * Shouldn't be used - use FML instead...
 * 
 * @deprecated
 */
public class ShortConsoleLogFormatter extends Formatter {
    private final SimpleDateFormat date;

    public ShortConsoleLogFormatter(MinecraftServer server) {
        /*PropertyManager options = ((DedicatedServer) server).settings;
        SimpleDateFormat date = null;

        if (options.has("date-format")) {
            try {
                Object object = options.valueOf("date-format");

                if ((object != null) && (object instanceof SimpleDateFormat)) {
                    date = (SimpleDateFormat) object;
                }
            } catch (Exception ex) {
                System.err.println("Given date format is not valid. Falling back to default.");
            }
        } else if (options.has("nojline")) {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }

        if (date == null) {
            
        }

        this.date = date;*/
    	this.date = new SimpleDateFormat("HH:mm:ss");
    	//this.date = date;
    }

    @Override
    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder();
        Throwable ex = record.getThrown();

        builder.append(date.format(record.getMillis()));
        builder.append(" [");
        builder.append(record.getLevel().getLocalizedName().toUpperCase());
        builder.append("] ");
        builder.append(formatMessage(record));
        builder.append('\n');

        if (ex != null) {
            StringWriter writer = new StringWriter();
            ex.printStackTrace(new PrintWriter(writer));
            builder.append(writer);
        }

        return builder.toString();
    }

}
