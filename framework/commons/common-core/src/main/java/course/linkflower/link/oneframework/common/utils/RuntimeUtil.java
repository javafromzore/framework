package course.linkflower.link.oneframework.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

public class RuntimeUtil {

    public static String hostName = null;
    public static Map<String, Properties> propertiesMap = null;

    public static String nodeId =  null;

    public static String getHOstNameSrc() {
        try {
            String result = InetAddress.getLocalHost().getHostName();
            if (StringUtils.isNotEmpty( result))
                return result;
        } catch (UnknownHostException e) {}
        String host = System.getenv("COMPUTERNAME");
        if (host != null)
            return host;
        host = System.getenv("HOSTNAME");
        if (host != null)
            return host;
        try {
            return executeCommand("hostname");
        } catch (Exception e) {}

        return null;
    }

    public static String getDataDir() {
        File f = new File(readPropertiesFile().getProperty("e2cef.application.datadir", "."));
        return  f.getAbsolutePath();
    }

    public static String getNodeId() {
        if (nodeId != null) {
            return  nodeId;
        }
        try {
            Path myid = Paths.get(getDataDir(), "myid");
            if (myid.toFile().exists()) {
                byte[] bs = Files.readAllBytes(myid);
                nodeId = new String(bs, StandardCharsets.UTF_8);
            } else {
                nodeId = String.valueOf(new Random().nextInt());
                Files.write(myid, nodeId.getBytes(StandardCharsets.UTF_8));
            }
        } catch (Exception e) {}

        return nodeId;
    }
    private static String executeCommand(String command) throws IOException {
        return new BufferedReader(
                new InputStreamReader(Runtime.getRuntime().exec(command).getInputStream()))
                .readLine();
    }

    public static String getAppHostName(String appName) {
        return appName + "@" + getHostName();
    }

    public static String[] parserAppHostName(String appHostName) {
        return appHostName.split("@");
    }

    public static String getHostName() {
        if (hostName == null) {
            hostName = getHOstNameSrc();

        }
        if (hostName == null) {
            hostName = getNodeId();
        }

        return hostName;
    }

    public static Properties readPropertiesFile(String file) {
        if (propertiesMap == null) {
            propertiesMap = new HashMap<>();
        } else {
            Properties p = propertiesMap.get(file);
            if (p != null) {
                return p;
            }
        }
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        try (InputStream resourceStream = loader.getResourceAsStream(file)) {
            properties.load(resourceStream);
            properties.put(file, properties);
        } catch (IOException e) {}

        return null;
    }

    public static Properties readPropertiesFile() {
        return readPropertiesFile("application.properties");
    }

}
