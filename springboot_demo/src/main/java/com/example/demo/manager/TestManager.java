package com.example.demo.manager;

import com.example.demo.dataobject.TestDO;
import com.example.demo.jpa.TestJpaDAO;
import com.example.demo.mapper.TestMapper;
import javafx.scene.media.AudioClip;
import lombok.extern.slf4j.Slf4j;
import lx.jave.AudioInfo;
import lx.jave.Encoder;
import lx.jave.EncoderException;
import lx.jave.MultimediaInfo;
import org.apache.el.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
 * @author SanKai
 * @since 2019-10-25
 */
@Service
@Slf4j
public class TestManager {

    @Autowired(required = false)
    private TestMapper testMapper;

    @Autowired
    private TestJpaDAO testJpaDAO;

    public List<TestDO> findAll() {
        return testMapper.findAll();
//        return testJpaDAO.findAll();
    }

    public boolean upload(Long id, MultipartFile file) {
        List<String> imageType = new ArrayList<>(Arrays.asList("jpg", "png", "jpeg", "bmp", "git"));
        TestDO testDO = testJpaDAO.findAllById(id);
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));//后缀名
        //只有当满足图片格式，重新赋图片名
        String filePath = "/Users/sankai/Documents/image/";
        fileName = UUID.randomUUID() + fileSuffix;
        String fileReplaceName = fileName.replaceAll("-", "");
        File newFile = new File(filePath + fileReplaceName);
        try {
            if (!newFile.getParentFile().exists()) {
                newFile.getParentFile().mkdir();
            }
            file.transferTo(newFile);
            testDO.setFileName(fileReplaceName);
            if (testDO.getCreateTime() == null) {
                testDO.setCreateTime(new Date());
            }
            testDO.setUpdateTime(new Date());
            testJpaDAO.save(testDO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean ddd() throws IOException {
        Encoder encoder = new Encoder();
        long ls = 0;
        MultimediaInfo m;
        try {
            File source = new File("https://insurance-h5.oss-cn-hangzhou.aliyuncs.com/darling-app/qa/audio/123123123.mp3");
            m = encoder.getInfo(source);
            ls = m.getDuration()/1000;
            System.out.println(ls);

        } catch (Exception e) {
            System.out.println("获取音频时长有误：" + e.getMessage());
        }
//        URL url = new URL("https://insurance-h5.oss-cn-hangzhou.aliyuncs.com/darling-app/qa/audio/123123123.mp3");
//        HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
//        // 根据响应获取文件大小
//        int fileLength = urlcon.getContentLength();
//        System.out.println(fileLength);

//        // 多媒体信息
//        try {
//            MultimediaInfo info = encoder.getInfo(file);
//
//            long duration = info.getDuration();
//            System.out.println("视频时长为：" + duration / 1000 + "秒");
//            // 音频信息
//            AudioInfo audio = info.getAudio();
//            int bitRate = audio.getBitRate();  // 比特率
//            int channels = audio.getChannels();  // 声道
//            String decoder = audio.getDecoder();  // 解码器
//            int sRate = audio.getSamplingRate();  // 采样率
//            System.out.println(duration);
//            System.out.println("解码器：" + decoder + "，声道：" + channels + "，比特率：" + bitRate + "，采样率：" + sRate);
//        } catch (EncoderException e) {
//            e.printStackTrace();
//        }
//        System.out.println(url.toExternalForm());
//            Clip clip = AudioSystem.getClip();
//            URL url = new URL("https://insurance-h5.oss-cn-hangzhou.aliyuncs.com/darling-app/qa/audio/123123123.mp3");
//            connection = url.openConnection();
//            BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
//            Bitstream bt = new Bitstream(bis);
//
//
//            MP3File
//            Header header = bt.readFrame();
//
//            int mp3Length = connection.getContentLength();
//
//            int time = (int) header.total_ms(mp3Length);
//            System.out.println("时长：" + time + "s");


//            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
//            clip.open(ais);
//            System.out.println(clip.getMicrosecondLength() / 1000000D + "s");
//        File file = new File("https://insurance-h5.oss-cn-hangzhou.aliyuncs.com/darling-app/qa/audio/123123123.mp3");
//        System.setProperty("ffmpeg.home", "/usr/local/Cellar/ffmpeg/4.2.1_2/bin");
//            Encoder encoder = new Encoder();
//            MultimediaInfo info = encoder.getInfo(file);
//            long duration = info.getDuration();
//            System.out.println("音频时长为：" + duration / 1000 + "秒");
//            AudioInfo audio = info.getAudio();
//            int bitRate = audio.getBitRate();  // 比特率
//            int channels = audio.getChannels();  // 声道
//            String decoder = audio.getDecoder();  // 解码器
//            int sRate = audio.getSamplingRate();  // 采样率
//            System.out.println("解码器：" + decoder + "，声道：" + channels + "，比特率：" + bitRate + "，采样率：" + sRate);
        return true;
    }
//
//    public static File getFileByUrl(String url) throws UnknownHostException, IOException {
//        File tmpFile = File.createTempFile("temp", ".tmp");//创建临时文件
//        Image.toBDFile(url, tmpFile.getCanonicalPath());
//        return tmpFile;
//    }
//
//    /**
//     * 获取时长
//     *
//     * @param url
//     * @return
//     * @throws IOException
//     * @throws InputFormatException
//     * @throws EncoderException
//     */
//    public static long getDuration(File file) throws EncoderException {
//        MultimediaInfo m = new Encoder().getInfo(file);
//        return m.getDuration();
//    }
//
//    /**
//     * 获取http://mp4.res.hunantv.com/new_video/28/7A0B569858C4B58526273897A2321658_20170926_1_1_256.mp4
//     * 时长信息和大小信息
//     *
//     * @param args
//     */
//    public static void main(String[] args) {
//        try {
//            File file = getFileByUrl("https://insurance-h5.oss-cn-hangzhou.aliyuncs.com/darling-app/qa/audio/123123123.mp3");
//            System.out.println("视频大小：" + file.length() / 1024 + "kb");
//            System.out.println("视频时长：" + getDuration(file) / 1000 + "s");
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//
//
//    }
}