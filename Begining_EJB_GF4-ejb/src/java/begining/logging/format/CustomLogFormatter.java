/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.logging.format;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 *
 * @author Eiichi Tanaka
 * java.util.logging のカスタムフォーマッター
 * ※本クラスは未使用(GlassFishのロガー設定となってしまうため)
 */
public class CustomLogFormatter extends Formatter {
    private final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private final String NL = System.getProperty("line.separator");

    @Override
    public String format(LogRecord record) {
        final StringBuffer sb = new StringBuffer();
        
        /***********************************************************************
         * 日時を出力
         **********************************************************************/
        sb.append(dateFormat.format(
                new Date(record.getMillis())));
        sb.append(" ");
        
        /***********************************************************************
         * ログレベルを出力
         **********************************************************************/
        String level = null;
        if (record.getLevel() == Level.FINEST) {
            level = Level.FINEST.toString();
        } else if (record.getLevel() == Level.FINER) {
            level = Level.FINER.toString();
        } else if (record.getLevel() == Level.FINE) {
            level = Level.FINE.toString();
        } else if (record.getLevel() == Level.CONFIG) {
            level = Level.CONFIG.toString();
        } else if (record.getLevel() == Level.INFO) {
            level = Level.INFO.toString();
        } else if (record.getLevel() == Level.WARNING) {
            level = Level.WARNING.toString();
        } else if (record.getLevel() == Level.SEVERE) {
            level = Level.SEVERE.toString();
        } else {
            level = Integer.toString(record.getLevel().intValue());
        }
        sb.append(level).append(" ");
        
        /***********************************************************************
         * ロガー名、ログメッセージ
         **********************************************************************/
        sb.append(record.getLoggerName()).append(" - ");
        sb.append(record.getMessage()).append(NL);

        return sb.toString();
    }
    
}
