package com.dhrs.base.controller;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/base")
@RefreshScope
public class BaseController {


    @RequestMapping("/add")
    public String add(){
        return "测试base服务调用";
    }

    @CrossOrigin
    @RequestMapping("/upload")
    public String  uploadPicture(@RequestParam("file") MultipartFile file){

        File targetFile=null;
        String url="";//返回存储路径
        String fileName=file.getOriginalFilename();//获取文件名加后缀
        if(fileName!=null&&fileName!=""){
            String path = "E:/data/file/";
            //String path = "D:/data/file/";
            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
            if (!(fileF.equals(".jpg") || fileF.equals(".jpeg") || fileF.equals(".png") || fileF.equals(".image"))) {

                return "只能上传jpg,jpeg,png,image格式";
            }
            //新的文件名
            fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+fileF;
            //获取文件夹路径
            File file1=new File(path);
            //如果文件夹不存在则创建
            if(!file1.exists()  && !file1.isDirectory()){
                file1.mkdirs();
            }
            //将图片存入文件夹
            targetFile = new File(file1, fileName);
            try {
                //将上传的文件写到服务器上指定的文件。
                file.transferTo(targetFile);
                //赋予权限
//                String command = "chmod 775 -R " + targetFile;
//                Runtime runtime = Runtime.getRuntime();
//                Process proc = runtime.exec(command);
                //生成文件地址
                url="http://192.168.0.101"+path+"/"+fileName;
                System.out.println("图片上传成功 url:"+url);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return url;
    }

    public static void main(String[] args) {
        int[] arr = {59,99,12,6,55,31,88,13,66,60,48,45};
        long l1 = System.currentTimeMillis();
        quickSort(arr,0,11);
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);
        Arrays.stream(arr).forEach(e -> {
            System.out.print(e+" ");
        });
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }
}
