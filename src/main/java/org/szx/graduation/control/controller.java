package org.szx.graduation.control;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.szx.graduation.dao.*;
import org.szx.graduation.dataobject.*;
import org.szx.graduation.model.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class controller {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private HeadPortraitDAO headPortraitDAO;
    @Autowired
    private ScenicspotDAO scenicspotDAO;
    @Autowired
    private PictureDAO pictureDAO;
    @Autowired
    private CommentDAO commentDAO;
    @Autowired
    private ShoppingCartDAO shoppingCartDAO;

    private static int  pageNum=0;

    @Value("${num}")
    private int number;

    @GetMapping("/szx/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        return "/login";
    }

    @GetMapping("/szx/register")
    public String register(Model model){
        model.addAttribute("user",new User());
        return "/register";
    }

    @PostMapping("/szx/gather")
    public String gather(@RequestParam("city")String city,@RequestParam("sort")String sort,Model model){
        List<ScenicspotDO> list ;
        List<String> picture=new ArrayList<>();
        List<String> name=new ArrayList<>();
        List<String> urls=new ArrayList<>();
        String url;
        String p;
        int l;
        int w;
        Gather gather=new Gather();
        if (!city.equals("城市")&&!sort.equals("景点类别")){
            list=scenicspotDAO.findByTwo(city,sort);
            gather.setAr("two");
            w=list.size();
            for (int j=0;j<w;j++){
                l= (int) list.get(j).getId();
                p=pictureDAO.findByPid(l).get(0).getUrl();
                picture.add(j,p);
                name.add(j,list.get(j).getSname());
                url="/szx/productPage?name="+list.get(j).getSname();
                urls.add(j,url);
            }
            gather.setCity(city);
            gather.setSort(sort);
            gather.setName(name);
            gather.setUrl(urls);
            gather.setPicture(picture);
        }
        if (city.equals("城市")&&!sort.equals("景点类别")){
            list=scenicspotDAO.findBySort(sort);
            gather.setAr("sort");
            String c=" ";
            w=list.size();
            for (int j=0;j<w;j++){
                l= (int) list.get(j).getId();
                p=pictureDAO.findByPid(l).get(0).getUrl();
                picture.add(j,p);
                name.add(j,list.get(j).getSname());
                url="/szx/productPage?name="+list.get(j).getSname();
                urls.add(j,url);
            }
            gather.setCity(c);
            gather.setSort(sort);
            gather.setName(name);
            gather.setUrl(urls);
            gather.setPicture(picture);
        }
        if (!city.equals("城市")&&sort.equals("景点类别")){
            list=scenicspotDAO.findByCity(city);
            String s=" ";
            gather.setAr("city");
            w=list.size();
            for (int j=0;j<w;j++){
                l= (int) list.get(j).getId();
                p=pictureDAO.findByPid(l).get(0).getUrl();
                picture.add(j,p);
                name.add(j,list.get(j).getSname());
                url="/szx/productPage?name="+list.get(j).getSname();
                urls.add(j,url);
            }
            gather.setCity(city);
            gather.setSort(s);
            gather.setName(name);
            gather.setUrl(urls);
            gather.setPicture(picture);
        }
        if (city.equals("城市")&&sort.equals("景点类别")){
            list=scenicspotDAO.findByCity(city);
            String cr=" ",sr=" ";
            gather.setAr("none");
            w=list.size();
            for (int j=0;j<w;j++){
                l= (int) list.get(j).getId();
                p=pictureDAO.findByPid(l).get(0).getUrl();
                picture.add(j,p);
                name.add(j,list.get(j).getSname());
                url="/szx/productPage?name="+list.get(j).getSname();
                urls.add(j,url);
            }
            gather.setCity(cr);
            gather.setSort(sr);
            gather.setName(name);
            gather.setUrl(urls);
            gather.setPicture(picture);
        }
        model.addAttribute("gather",gather);
        return "/gather";
    }

    @PostMapping("/szx/gatherr")
    public String gatherr(@RequestParam("city")String city,@RequestParam("sort")String sort,Model model,HttpServletRequest request){
        // 取得 HttpSession 对象
        HttpSession session = request.getSession();
        UserLoginInfo userLoginInfo=(UserLoginInfo)session.getAttribute("userLoginInfo");
        UserDO userDO5=userDAO.findByUserAccount(userLoginInfo.getUserAccount());
        List<ScenicspotDO> list ;
        List<String> picture=new ArrayList<>();
        List<String> name=new ArrayList<>();
        List<String> urls=new ArrayList<>();
        String url;
        String p;
        int l;
        int w;
        Gather gather=new Gather();
        if (!city.equals("城市")&&!sort.equals("景点类别")){
            list=scenicspotDAO.findByTwo(city,sort);
            gather.setAr("two");
            w=list.size();
            for (int j=0;j<w;j++){
                l= (int) list.get(j).getId();
                p=pictureDAO.findByPid(l).get(0).getUrl();
                picture.add(j,p);
                name.add(j,list.get(j).getSname());
                url="/szx/productPager?name="+list.get(j).getSname();
                urls.add(j,url);
            }
            gather.setCity(city);
            gather.setSort(sort);
            gather.setName(name);
            gather.setUrl(urls);
            gather.setPicture(picture);
        }
        if (city.equals("城市")&&!sort.equals("景点类别")){
            list=scenicspotDAO.findBySort(sort);
            gather.setAr("sort");
            String c=" ";
            w=list.size();
            for (int j=0;j<w;j++){
                l= (int) list.get(j).getId();
                p=pictureDAO.findByPid(l).get(0).getUrl();
                picture.add(j,p);
                name.add(j,list.get(j).getSname());
                url="/szx/productPager?name="+list.get(j).getSname();
                urls.add(j,url);
            }
            gather.setCity(c);
            gather.setSort(sort);
            gather.setName(name);
            gather.setUrl(urls);
            gather.setPicture(picture);
        }
        if (!city.equals("城市")&&sort.equals("景点类别")){
            list=scenicspotDAO.findByCity(city);
            String s=" ";
            gather.setAr("city");
            w=list.size();
            for (int j=0;j<w;j++){
                l= (int) list.get(j).getId();
                p=pictureDAO.findByPid(l).get(0).getUrl();
                picture.add(j,p);
                name.add(j,list.get(j).getSname());
                url="/szx/productPager?name="+list.get(j).getSname();
                urls.add(j,url);
            }
            gather.setCity(city);
            gather.setSort(s);
            gather.setName(name);
            gather.setUrl(urls);
            gather.setPicture(picture);
        }
        if (city.equals("城市")&&sort.equals("景点类别")){
            list=scenicspotDAO.findByCity(city);
            String cr=" ",sr=" ";
            gather.setAr("none");
            w=list.size();
            for (int j=0;j<w;j++){
                l= (int) list.get(j).getId();
                p=pictureDAO.findByPid(l).get(0).getUrl();
                picture.add(j,p);
                name.add(j,list.get(j).getSname());
                url="/szx/productPager?name="+list.get(j).getSname();
                urls.add(j,url);
            }
            gather.setCity(cr);
            gather.setSort(sr);
            gather.setName(name);
            gather.setUrl(urls);
            gather.setPicture(picture);
        }
        User user=userDO5.model();
        gather.setUser(user);
        model.addAttribute("gather",gather);
        return "/gatherr";
    }

    @PostMapping("/szx/search")
    public String search(@Valid scenicspot sc,Model model){
        List<ScenicspotDO> list= scenicspotDAO.findByName(sc.getSname());
        int w=list.size();
        int j=0;
        String us;
        ScenicspotDO scenicspotDO2=new ScenicspotDO();
        scenicspotDO2.setSname("无结果");
        for (;j<number;j++){
            if (j>=w) {
                list.add(j,scenicspotDO2);
            }
            us="/szx/productPage?name="+list.get(j).getSname();
            list.get(j).setUr(us);
        }
        Page<ScenicspotDO> page=PageHelper.startPage(pageNum,10).doSelectPage(()->scenicspotDAO.findAll());
        List<ScenicspotDO> lists=new ArrayList<>();
        for (ScenicspotDO scenicspotDO:page.getResult()){
            scenicspotDO.setUrls(pictureDAO.findByPid((int) scenicspotDO.getId()));
            String name=scenicspotDO.getSname();
            scenicspotDO.setUr("/szx/productPage?name="+name);
            lists.add(scenicspotDO);
        }
        ScenicspotDO scenicspotDO1=new ScenicspotDO();
        int[] ir = new int[10];
        for (int i=1;i<=page.getPages();i++){
            ir[i-1]=i;
        }
        scenicspotDO1.setPageNum(ir);
        scenicspotDO1.setId(pageNum);
        Collections.shuffle(lists);
        lists.add(10,scenicspotDO1);
        Search search=new Search();
        search.setList1(lists);
        search.setList2(list);
        model.addAttribute("search",search);
        return "/homepage";
    }

    @PostMapping("/szx/searchr")
    public String searchr(@Valid scenicspot sc,Model model,HttpServletRequest request){
        // 取得 HttpSession 对象
        HttpSession session = request.getSession();
        UserLoginInfo userLoginInfo=(UserLoginInfo)session.getAttribute("userLoginInfo");
        UserDO userDO5=userDAO.findByUserAccount(userLoginInfo.getUserAccount());
        List<ScenicspotDO> list= scenicspotDAO.findByName(sc.getSname());
        int w=list.size();
        int j=0;
        String us;
        ScenicspotDO scenicspotDO2=new ScenicspotDO();
        scenicspotDO2.setSname("无结果");
        for (;j<number;j++){
            if (j>=w) {
                list.add(j,scenicspotDO2);
            }
            us="/szx/productPager?name="+list.get(j).getSname();
            list.get(j).setUr(us);
        }
        Page<ScenicspotDO> page=PageHelper.startPage(pageNum,10).doSelectPage(()->scenicspotDAO.findAll());
        List<ScenicspotDO> lists=new ArrayList<>();
        for (ScenicspotDO scenicspotDO:page.getResult()){
            scenicspotDO.setUrls(pictureDAO.findByPid((int) scenicspotDO.getId()));
            String name=scenicspotDO.getSname();
            scenicspotDO.setUr("/szx/productPager?name="+name);
            lists.add(scenicspotDO);
        }
        ScenicspotDO scenicspotDO1=new ScenicspotDO();
        int[] ir = new int[10];
        for (int i=1;i<=page.getPages();i++){
            ir[i-1]=i;
        }
        scenicspotDO1.setPageNum(ir);
        scenicspotDO1.setId(pageNum);
        Collections.shuffle(lists);
        lists.add(10,scenicspotDO1);
        User user=userDO5.model();
        user.setSc(lists);
        Searchr searchr=new Searchr();
        searchr.setList1(list);
        searchr.setUser(user);
        model.addAttribute("searchr",searchr);
        return "/homepager";
    }

    @GetMapping("/szx/changpassword")
    public String changpassword(@RequestParam("login")String login, Model model){
        User user=new User();
        String url = null;
        if (login.equals("true")){
            url="/szx/homepager";
        }
        else url="/szx/homepage";
        user.setUr(url);
        model.addAttribute("user",user);
        return "/changpassword";
    }

    @PostMapping("/szx/changpassword1")
    public String changPassword1(HttpServletRequest request,Model model,@Valid User user, BindingResult errors){
        // 取得 HttpSession 对象
        HttpSession session = request.getSession();
        UserLoginInfo userLoginInfo =(UserLoginInfo) session.getAttribute("userLoginInfo");
        if (errors.hasErrors()){
            return "/changpassword";
        }
        UserDO userDO1=userDAO.findByUserAccount(user.getAccount());
        if (userDO1==null){
            if (userLoginInfo==null){
                user.setUr("/szx/homepage");
            }
            else user.setUr("/szx/homepager");
            model.addAttribute("user",user);
            return "/loginAccountFailure";
        }
        if (user.getConfirmPwd()==null){
            if (userLoginInfo==null){
                user.setUr("/szx/homepage");
            }
            else user.setUr("/szx/homepager");
            model.addAttribute("user",user);
            return "/registerPwdFailure";
        }
        if (user.getConfirmPwd().equals(user.getPwd())){
            userDO1.setPwd(user.getPwd());
            userDAO.update(userDO1);
            if (userLoginInfo==null){
                UserLoginInfo userLoginInfo1=new UserLoginInfo();
                userLoginInfo1.setUserAccount(user.getAccount());
                userLoginInfo1.setUserPwd(user.getPwd());
                session.setAttribute("userLoginInfo", userLoginInfo1);
            }
            UserDO userDO=userDAO.findByUserAccount(user.getAccount());
            userDO.setPwd(user.getPwd());
            pageNum=1;
            Page<ScenicspotDO> page1=PageHelper.startPage(pageNum,10).doSelectPage(()->scenicspotDAO.findAll());
            List<ScenicspotDO> lists=new ArrayList<>();
            for (ScenicspotDO scenicspotDO:page1.getResult()){
                scenicspotDO.setUrls(pictureDAO.findByPid((int) scenicspotDO.getId()));
                lists.add(scenicspotDO);
            }
            ScenicspotDO scenicspotDO1=new ScenicspotDO();
            int[] ir = new int[10];
            for (int it=1;it<=page1.getPages();it++){
                ir[it-1]=it;
            }
            scenicspotDO1.setPageNum(ir);
            scenicspotDO1.setId(pageNum);
            Collections.shuffle(lists);
            lists.add(10,scenicspotDO1);
            User user1=userDO.model();
            user1.setSc(lists);
            List<ScenicspotDO> list=new ArrayList<>();
            ScenicspotDO scenicspotDO2=new ScenicspotDO();
            scenicspotDO2.setSname("无结果");
            for (int j=0;j<number;j++){
                list.add(j,scenicspotDO2);
            }
            Searchr searchr=new Searchr();
            searchr.setUser(user1);
            searchr.setList1(list);
            model.addAttribute("searchr",searchr);
            return "/homepager";
        }
        if (userLoginInfo==null){
            user.setUr("/szx/homepage");
        }
        else user.setUr("/szx/homepager");
        model.addAttribute("user",user);
        return "/registerPwdFailure";
    }

    @PostMapping("/szx/registerVerify")
    public String registerVerify(HttpServletRequest request,Model model,@Valid User user, BindingResult errors){
        if (errors.hasErrors()){
            return "/register";
        }
        UserDO userDO1=userDAO.findByUserAccount(user.getAccount());
        if (userDO1!=null){
            return "/registerAccountFailure";
        }
        if (user.getConfirmPwd()==null){
            user.setUr("/szx/homepage");
            model.addAttribute("user",user);
            return "/registerPwdFailure";
        }
        if (user.getConfirmPwd().equals(user.getPwd())){
            UserLoginInfo userLoginInfo = new UserLoginInfo();
            userLoginInfo.setUserAccount(user.getAccount());
            userLoginInfo.setUserPwd(user.getPwd());
            // 取得 HttpSession 对象
            HttpSession session = request.getSession();
            // 写入登录信息
            session.setAttribute("userLoginInfo", userLoginInfo);
            UserDO userDO2=new UserDO();
            Page<HeadPortraitDO> page= PageHelper.startPage(1,10).doSelectPage(()->headPortraitDAO.findAll());
            long i=page.getTotal();
            Random r=new Random();
            int num=r.nextInt((int) i)+1;
            userDO2.setHeadPortrait(headPortraitDAO.findById(num).getUrl());
            userDO2.setAccount(user.getAccount());
            userDO2.setPwd(user.getPwd());
            userDAO.insert(userDO2);
            UserDO userDO3=userDAO.findByUserAccount(userLoginInfo.getUserAccount());
            String name="用户"+userDO3.getId();
            userDO2.setUserName(name);
            pageNum=1;
            Page<ScenicspotDO> page1=PageHelper.startPage(pageNum,10).doSelectPage(()->scenicspotDAO.findAll());
            List<ScenicspotDO> lists=new ArrayList<>();
            for (ScenicspotDO scenicspotDO:page1.getResult()){
                scenicspotDO.setUrls(pictureDAO.findByPid((int) scenicspotDO.getId()));
                String namer=scenicspotDO.getSname();
                scenicspotDO.setUr("/szx/productPager?name="+namer);
                lists.add(scenicspotDO);
            }
            ScenicspotDO scenicspotDO1=new ScenicspotDO();
            int[] ir = new int[10];
            for (int it=1;it<=page1.getPages();it++){
                ir[it-1]=it;
            }
            scenicspotDO1.setPageNum(ir);
            scenicspotDO1.setId(pageNum);
            Collections.shuffle(lists);
            lists.add(10,scenicspotDO1);
            User user1=userDO2.model();
            user1.setSc(lists);
            List<ScenicspotDO> list=new ArrayList<>();
            ScenicspotDO scenicspotDO2=new ScenicspotDO();
            scenicspotDO2.setSname("无结果");
            for (int j=0;j<number;j++){
                list.add(j,scenicspotDO2);
            }
            Searchr searchr=new Searchr();
            searchr.setList1(list);
            searchr.setUser(user1);
            model.addAttribute("searchr",searchr);
            return "/homepager";
        }
        user.setUr("/szx/homepage");
        model.addAttribute("user",user);
        return "/registerPwdFailure";
    }

    @PostMapping("/szx/loginVerify")
    public String loginVerify(@Valid User user, BindingResult errors,HttpServletRequest request,Model model){
        if (errors.hasErrors()){
            return "/login";
        }
        UserDO userDO4=userDAO.findByUserAccount(user.getAccount());
        if (userDO4!=null){
            if (userDO4.getPwd().equals(user.getPwd())){// 如果对比用户名和密码成功
                UserLoginInfo userLoginInfo = new UserLoginInfo();
                userLoginInfo.setUserAccount(user.getAccount());
                userLoginInfo.setUserPwd("1234567");
                // 取得 HttpSession 对象
                HttpSession session = request.getSession();
                // 写入登录信息
                session.setAttribute("userLoginInfo", userLoginInfo);
                pageNum=1;
                Page<ScenicspotDO> page=PageHelper.startPage(pageNum,10).doSelectPage(()->scenicspotDAO.findAll());
                List<ScenicspotDO> lists=new ArrayList<>();
                for (ScenicspotDO scenicspotDO:page.getResult()){
                    scenicspotDO.setUrls(pictureDAO.findByPid((int) scenicspotDO.getId()));
                    String name=scenicspotDO.getSname();
                    scenicspotDO.setUr("/szx/productPager?name="+name);
                    lists.add(scenicspotDO);
                }
                ScenicspotDO scenicspotDO1=new ScenicspotDO();
                int[] ir = new int[10];
                for (int i=1;i<=page.getPages();i++){
                    ir[i-1]=i;
                }
                scenicspotDO1.setPageNum(ir);
                scenicspotDO1.setId(pageNum);
                Collections.shuffle(lists);
                lists.add(10,scenicspotDO1);
                User user1=userDO4.model();
                user1.setSc(lists);
                List<ScenicspotDO> list=new ArrayList<>();
                ScenicspotDO scenicspotDO2=new ScenicspotDO();
                scenicspotDO2.setSname("无结果");
                for (int j=0;j<number;j++){
                    list.add(j,scenicspotDO2);
                }
                Searchr searchr=new Searchr();
                searchr.setUser(user1);
                searchr.setList1(list);
                model.addAttribute("searchr",searchr);
                return "/homepager";
            }
            return "/loginPwdFailure";
        }
        user.setUr("/szx/homepage");
        model.addAttribute("user",user);
        return "/loginAccountFailure";
    }

    @GetMapping("/szx/writeOff")
    public String writeOff(HttpServletRequest request,Model model){
        HttpSession session=request.getSession();
        UserLoginInfo userLoginInfo=(UserLoginInfo)session.getAttribute("userLoginInfo");
        userDAO.delete(userLoginInfo.getUserAccount());
        session.removeAttribute("userLoginInfo");
        pageNum=1;
        Page<ScenicspotDO> page=PageHelper.startPage(pageNum,10).doSelectPage(()->scenicspotDAO.findAll());
        List<ScenicspotDO> lists=new ArrayList<>();
        for (ScenicspotDO scenicspotDO:page.getResult()){
            scenicspotDO.setUrls(pictureDAO.findByPid((int) scenicspotDO.getId()));
            String name=scenicspotDO.getSname();
            scenicspotDO.setUr("/szx/productPage?name="+name);
            lists.add(scenicspotDO);
        }
        ScenicspotDO scenicspotDO1=new ScenicspotDO();
        int[] ir = new int[10];
        for (int i=1;i<=page.getPages();i++){
            ir[i-1]=i;
        }
        scenicspotDO1.setPageNum(ir);
        scenicspotDO1.setId(pageNum);
        Collections.shuffle(lists);
        lists.add(10,scenicspotDO1);
        List<ScenicspotDO> list=new ArrayList<>();
        ScenicspotDO scenicspotDO2=new ScenicspotDO();
        scenicspotDO2.setSname("无结果");
        for (int j=0;j<number;j++){
            list.add(j,scenicspotDO2);
        }
        Search search=new Search();
        search.setList1(lists);
        search.setList2(list);
        model.addAttribute("search",search);
        return "/homepage";
    }
    @GetMapping("/szx/logout")
    public String logout(HttpServletRequest request,Model model){
        HttpSession session=request.getSession();
        session.removeAttribute("userLoginInfo");
        pageNum=1;
        Page<ScenicspotDO> page=PageHelper.startPage(pageNum,10).doSelectPage(()->scenicspotDAO.findAll());
        List<ScenicspotDO> lists=new ArrayList<>();
        for (ScenicspotDO scenicspotDO:page.getResult()){
            scenicspotDO.setUrls(pictureDAO.findByPid((int) scenicspotDO.getId()));
            String name=scenicspotDO.getSname();
            scenicspotDO.setUr("/szx/productPage?name="+name);
            lists.add(scenicspotDO);
        }
        ScenicspotDO scenicspotDO1=new ScenicspotDO();
        int[] ir = new int[10];
        for (int i=1;i<=page.getPages();i++){
            ir[i-1]=i;
        }
        scenicspotDO1.setPageNum(ir);
        scenicspotDO1.setId(pageNum);
        Collections.shuffle(lists);
        lists.add(10,scenicspotDO1);
        List<ScenicspotDO> list=new ArrayList<>();
        ScenicspotDO scenicspotDO2=new ScenicspotDO();
        scenicspotDO2.setSname("无结果");
        for (int j=0;j<number;j++){
            list.add(j,scenicspotDO2);
        }
        Search search=new Search();
        search.setList1(lists);
        search.setList2(list);
        model.addAttribute("search",search);
        return "/homepage";
    }

    @GetMapping("/personal/personalcenter")
    public String personalcenter(HttpServletRequest request,Model model){
        HttpSession session=request.getSession();
        UserLoginInfo userLoginInfo=(UserLoginInfo)session.getAttribute("userLoginInfo");
        UserDO userDO=userDAO.findByUserAccount(userLoginInfo.getUserAccount());
        model.addAttribute("user",userDO.model());
        return "/personalcenter";
    }

    @GetMapping("/szx/homepage")
    public String homepage( Model model){
        pageNum++;
        Page<ScenicspotDO> page=PageHelper.startPage(pageNum,10).doSelectPage(()->scenicspotDAO.findAll());
        if (pageNum>page.getPages()){
            pageNum=1;
            page=PageHelper.startPage(pageNum,10).doSelectPage(()->scenicspotDAO.findAll());
        }
        List<ScenicspotDO> lists=new ArrayList<>();
        for (ScenicspotDO scenicspotDO:page.getResult()){
            scenicspotDO.setUrls(pictureDAO.findByPid((int) scenicspotDO.getId()));
            String name=scenicspotDO.getSname();
            scenicspotDO.setUr("/szx/productPage?name="+name);
            lists.add(scenicspotDO);
        }
        ScenicspotDO scenicspotDO1=new ScenicspotDO();
        int[] ir = new int[10];
        for (int i=1;i<=page.getPages();i++){
            ir[i-1]=i;
        }
        scenicspotDO1.setPageNum(ir);
        scenicspotDO1.setId(pageNum);
        scenicspotDO1.setCity("fla");
        Collections.shuffle(lists);
        lists.add(10,scenicspotDO1);
        List<ScenicspotDO> list=new ArrayList<>();
        ScenicspotDO scenicspotDO2=new ScenicspotDO();
        scenicspotDO2.setSname("无结果");
        for (int j=0;j<number;j++){
            list.add(j,scenicspotDO2);
        }
        Search search=new Search();
        search.setList1(lists);
        search.setList2(list);
        model.addAttribute("search",search);
        return "/homepage";
    }

    @GetMapping("/szx/refresh")
    public String refresh(Model model){
        Page<ScenicspotDO> page=PageHelper.startPage(pageNum,10).doSelectPage(()->scenicspotDAO.findAll());
        List<ScenicspotDO> lists=new ArrayList<>();
        for (ScenicspotDO scenicspotDO:page.getResult()){
            scenicspotDO.setUrls(pictureDAO.findByPid((int) scenicspotDO.getId()));
            String name=scenicspotDO.getSname();
            scenicspotDO.setUr("/szx/productPage?name="+name);
            lists.add(scenicspotDO);
        }
        ScenicspotDO scenicspotDO1=new ScenicspotDO();
        int[] ir = new int[10];
        for (int i=1;i<=page.getPages();i++){
            ir[i-1]=i;
        }
        scenicspotDO1.setPageNum(ir);
        scenicspotDO1.setId(pageNum);
        Collections.shuffle(lists);
        lists.add(10,scenicspotDO1);
        List<ScenicspotDO> list=new ArrayList<>();
        ScenicspotDO scenicspotDO2=new ScenicspotDO();
        scenicspotDO2.setSname("无结果");
        for (int j=0;j<number;j++){
            list.add(j,scenicspotDO2);
        }
        Search search=new Search();
        search.setList1(lists);
        search.setList2(list);
        model.addAttribute("search",search);
        return "/homepage";
    }

    @GetMapping("/szx/homepages")
    public String homepages( Model model){
        pageNum--;
        Page<ScenicspotDO> page=PageHelper.startPage(pageNum,10).doSelectPage(()->scenicspotDAO.findAll());
        if (pageNum==0){
            pageNum=page.getPages();
            page=PageHelper.startPage(pageNum,10).doSelectPage(()->scenicspotDAO.findAll());
        }
        List<ScenicspotDO> lists=new ArrayList<>();
        for (ScenicspotDO scenicspotDO:page.getResult()){
            scenicspotDO.setUrls(pictureDAO.findByPid((int) scenicspotDO.getId()));
            String name=scenicspotDO.getSname();
            scenicspotDO.setUr("/szx/productPage?name="+name);
            lists.add(scenicspotDO);
        }
        ScenicspotDO scenicspotDO1=new ScenicspotDO();
        int[] ir = new int[10];
        for (int i=1;i<=page.getPages();i++){
            ir[i-1]=i;
        }
        scenicspotDO1.setPageNum(ir);
        scenicspotDO1.setId(pageNum);
        Collections.shuffle(lists);
        lists.add(10,scenicspotDO1);
        List<ScenicspotDO> list=new ArrayList<>();
        ScenicspotDO scenicspotDO2=new ScenicspotDO();
        scenicspotDO2.setSname("无结果");
        for (int j=0;j<number;j++){
            list.add(j,scenicspotDO2);
        }
        Search search=new Search();
        search.setList1(lists);
        search.setList2(list);
        model.addAttribute("search",search);
        return "/homepage";
    }

    @GetMapping("/szx/homepager")
    public String homepager(Model model,HttpServletRequest request){
        // 取得 HttpSession 对象
        HttpSession session = request.getSession();
        UserLoginInfo userLoginInfo=(UserLoginInfo)session.getAttribute("userLoginInfo");
        UserDO userDO5=userDAO.findByUserAccount(userLoginInfo.getUserAccount());
        pageNum++;
        Page<ScenicspotDO> page1=PageHelper.startPage(pageNum,10).doSelectPage(()->scenicspotDAO.findAll());
        if (pageNum>page1.getPages()){
            pageNum=1;
            page1=PageHelper.startPage(pageNum,10).doSelectPage(()->scenicspotDAO.findAll());
        }
        List<ScenicspotDO> lists=new ArrayList<>();
        for (ScenicspotDO scenicspotDO:page1.getResult()){
            scenicspotDO.setUrls(pictureDAO.findByPid((int) scenicspotDO.getId()));
            String name=scenicspotDO.getSname();
            scenicspotDO.setUr("/szx/productPager?name="+name);
            lists.add(scenicspotDO);
        }
        ScenicspotDO scenicspotDO1=new ScenicspotDO();
        int[] ir = new int[10];
        for (int i=1;i<=page1.getPages();i++){
            ir[i-1]=i;
        }
        scenicspotDO1.setPageNum(ir);
        scenicspotDO1.setId(pageNum);
        Collections.shuffle(lists);
        lists.add(10,scenicspotDO1);
        User user1=userDO5.model();
        user1.setSc(lists);
        List<ScenicspotDO> list=new ArrayList<>();
        ScenicspotDO scenicspotDO2=new ScenicspotDO();
        scenicspotDO2.setSname("无结果");
        for (int j=0;j<number;j++){
            list.add(j,scenicspotDO2);
        }
        Searchr searchr=new Searchr();
        searchr.setList1(list);
        searchr.setUser(user1);
        model.addAttribute("searchr",searchr);
        return "/homepager";
    }

    @GetMapping("/szx/refreshr")
    public String refreshr(Model model,HttpServletRequest request){
        // 取得 HttpSession 对象
        HttpSession session = request.getSession();
        UserLoginInfo userLoginInfo=(UserLoginInfo)session.getAttribute("userLoginInfo");
        UserDO userDO5=userDAO.findByUserAccount(userLoginInfo.getUserAccount());
        Page<ScenicspotDO> page1=PageHelper.startPage(pageNum,10).doSelectPage(()->scenicspotDAO.findAll());
        List<ScenicspotDO> lists=new ArrayList<>();
        for (ScenicspotDO scenicspotDO:page1.getResult()){
            scenicspotDO.setUrls(pictureDAO.findByPid((int) scenicspotDO.getId()));
            String name=scenicspotDO.getSname();
            scenicspotDO.setUr("/szx/productPager?name="+name);
            lists.add(scenicspotDO);
        }
        ScenicspotDO scenicspotDO1=new ScenicspotDO();
        int[] ir = new int[10];
        for (int i=1;i<=page1.getPages();i++){
            ir[i-1]=i;
        }
        scenicspotDO1.setPageNum(ir);
        scenicspotDO1.setId(pageNum);
        Collections.shuffle(lists);
        lists.add(10,scenicspotDO1);
        User user1=userDO5.model();
        user1.setSc(lists);
        List<ScenicspotDO> list=new ArrayList<>();
        ScenicspotDO scenicspotDO2=new ScenicspotDO();
        scenicspotDO2.setSname("无结果");
        for (int j=0;j<number;j++){
            list.add(j,scenicspotDO2);
        }
        Searchr searchr=new Searchr();
        searchr.setUser(user1);
        searchr.setList1(list);
        model.addAttribute("searchr",searchr);
        return "/homepager";
    }

    @GetMapping("/szx/homepagers")
    public String homepagers( Model model,HttpServletRequest request){
        // 取得 HttpSession 对象
        HttpSession session = request.getSession();
        UserLoginInfo userLoginInfo=(UserLoginInfo)session.getAttribute("userLoginInfo");
        UserDO userDO5=userDAO.findByUserAccount(userLoginInfo.getUserAccount());
        pageNum--;
        Page<ScenicspotDO> page=PageHelper.startPage(pageNum,10).doSelectPage(()->scenicspotDAO.findAll());
        if (pageNum==0){
            pageNum=page.getPages();
            page=PageHelper.startPage(pageNum,10).doSelectPage(()->scenicspotDAO.findAll());
        }
        List<ScenicspotDO> lists=new ArrayList<>();
        for (ScenicspotDO scenicspotDO:page.getResult()){
            scenicspotDO.setUrls(pictureDAO.findByPid((int) scenicspotDO.getId()));
            String name=scenicspotDO.getSname();
            scenicspotDO.setUr("/szx/productPager?name="+name);
            lists.add(scenicspotDO);
        }
        ScenicspotDO scenicspotDO1=new ScenicspotDO();
        int[] ir = new int[10];
        for (int i=1;i<=page.getPages();i++){
            ir[i-1]=i;
        }
        scenicspotDO1.setPageNum(ir);
        scenicspotDO1.setId(pageNum);
        Collections.shuffle(lists);
        lists.add(10,scenicspotDO1);
        model.addAttribute("lists",lists);
        User user1=userDO5.model();
        user1.setSc(lists);
        List<ScenicspotDO> list=new ArrayList<>();
        ScenicspotDO scenicspotDO2=new ScenicspotDO();
        scenicspotDO2.setSname("无结果");
        for (int j=0;j<number;j++){
            list.add(j,scenicspotDO2);
        }
        Searchr searchr=new Searchr();
        searchr.setList1(list);
        searchr.setUser(user1);
        model.addAttribute("searchr",searchr);
        return "/homepager";
    }

    @PostMapping("/szx/productPage")
    public String productPage(@RequestParam("name")String name, Model model){
        List<ScenicspotDO> scenicspotDOs=scenicspotDAO.findByName(name);
        ScenicspotDO scenicspotDO=scenicspotDOs.get(0);
        scenicspotDO.setUrls(pictureDAO.findByPid((int) scenicspotDO.getId()));
        List<CommentDO> commentDO=commentDAO.findBySid((int) scenicspotDO.getId());
        List<String> headPortraitDOs = new ArrayList<>();
        List<String> uname = new ArrayList<>();
        List<String> content = new ArrayList<>();
        DateTimeFormatter date=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date1;
        LocalDateTime time1;
        int m=commentDO.size();
        for (int i=0,j=0;i<m&&j<2*m;i++,j++){
            time1=commentDO.get(i).getGmtCreated();
            date1=time1.format(date);
            name="用户"+commentDO.get(i).getUid();
            uname.add(j,name);
            j++;
            uname.add(j,date1);
            scenicspotDO.setUname(uname);
            headPortraitDOs.add(i,commentDO.get(i).getHeadPortraitDO());
            content.add(i,commentDO.get(i).getContent());
            scenicspotDO.setContent(content);
            scenicspotDO.setHeadPortraitDOs(headPortraitDOs);
        }
        model.addAttribute("scenicspotDO",scenicspotDO);
        return "/productPage";
    }

    @PostMapping("/szx/productPager")
    public String productPager(@RequestParam("name")String name, Model model,HttpServletRequest request){
        // 取得 HttpSession 对象
        HttpSession session = request.getSession();
        UserLoginInfo userLoginInfo=(UserLoginInfo)session.getAttribute("userLoginInfo");
        UserDO userDO5=userDAO.findByUserAccount(userLoginInfo.getUserAccount());
        List<ScenicspotDO> scenicspotDOs=scenicspotDAO.findByName(name);
        ScenicspotDO scenicspotDO=scenicspotDOs.get(0);
        scenicspotDO.setUrls(pictureDAO.findByPid((int) scenicspotDO.getId()));
        User user1=userDO5.model();
        List<CommentDO> commentDO=commentDAO.findBySid((int) scenicspotDO.getId());
        List<String> headPortraitDOs = new ArrayList<>();
        List<String> uname =new ArrayList<>();
        List<String> content = new ArrayList<>();
        DateTimeFormatter date=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date1;
        LocalDateTime time1;
        int m=commentDO.size();
        for (int i=0,j=0;i<m&&j<2*m;i++,j++){
            time1=commentDO.get(i).getGmtCreated();
            date1=time1.format(date);
            name="用户"+commentDO.get(i).getUid();
            uname.add(j,name);
            j++;
            uname.add(j,date1);
            scenicspotDO.setUname(uname);
            headPortraitDOs.add(i,commentDO.get(i).getHeadPortraitDO());
            content.add(i,commentDO.get(i).getContent());
            scenicspotDO.setContent(content);
            scenicspotDO.setHeadPortraitDOs(headPortraitDOs);
        }
        String url="/personal/insertshoppingCart?sname="+scenicspotDO.getSname();
        user1.setUr(url);
        user1.setScr(scenicspotDO);
        model.addAttribute("user",user1);
        return "/productPager";
    }

    @PostMapping("/personal/comment")
    public String comment(@Valid CommentDO commentDO1, Model model,HttpServletRequest request){
        // 取得 HttpSession 对象
        HttpSession session = request.getSession();
        UserLoginInfo userLoginInfo=(UserLoginInfo)session.getAttribute("userLoginInfo");
        CommentDO commentDO=new CommentDO();
        long id=Long.valueOf(commentDO1.getSid());
        commentDO.setSid(id);
        UserDO userDO=userDAO.findByUserAccount(userLoginInfo.getUserAccount());
        commentDO.setUid(userDO.getId());
        String name="用户"+userDO.getId();
        commentDO.setUname(name);
        commentDO.setSname(commentDO1.getSname());
        commentDO.setHeadPortraitDO(userDO.getHeadPortrait());
        commentDO.setContent(commentDO1.getContent());
        commentDAO.insert(commentDO);
        List<ScenicspotDO> scenicspotDOs=scenicspotDAO.findByName(commentDO1.getSname());
        ScenicspotDO scenicspotDO=scenicspotDOs.get(0);
        scenicspotDO.setUrls(pictureDAO.findByPid((int) scenicspotDO.getId()));
        User user1=userDO.model();
        List<CommentDO> commentDOs=commentDAO.findBySid((int) scenicspotDO.getId());
        List<String> headPortraitDOs = new ArrayList<>();
        List<String> uname = new ArrayList<>();
        List<String> contents = new ArrayList<>();
        DateTimeFormatter date=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date1;
        LocalDateTime time1;
        int m=commentDOs.size();
        for (int i=0,j=0;i<m&&j<2*m;i++,j++){
            time1=commentDOs.get(i).getGmtCreated();
            date1=time1.format(date);
            name="用户"+commentDOs.get(i).getUid();
            uname.add(j,name);
            j++;
            uname.add(j,date1);
            scenicspotDO.setUname(uname);
            headPortraitDOs.add(i,commentDOs.get(i).getHeadPortraitDO());
            contents.add(i,commentDOs.get(i).getContent());
            scenicspotDO.setContent(contents);
            scenicspotDO.setHeadPortraitDOs(headPortraitDOs);
        }
        user1.setScr(scenicspotDO);
        model.addAttribute("user",user1);
        return "/productPager";
    }

    @PostMapping("/personal/insertshoppingCart")
    public String insertshoppingCart(@RequestParam("sname") String sname,Model model,HttpServletRequest request){
        // 取得 HttpSession 对象
        HttpSession session = request.getSession();
        UserLoginInfo userLoginInfo=(UserLoginInfo)session.getAttribute("userLoginInfo");
        UserDO userDO=userDAO.findByUserAccount(userLoginInfo.getUserAccount());
        ShoppingCartDO shoppingCartDO=new ShoppingCartDO();
        ScenicspotDO scenicspotDO=scenicspotDAO.findByName(sname).get(0);
        int ie= (int) scenicspotDO.getId();
        String picture=pictureDAO.findByPid(ie).get(0).getUrl();
        shoppingCartDO.setPicture(picture);
        shoppingCartDO.setSid(scenicspotDO.getId());
        shoppingCartDO.setUid(userDO.getId());
        String name1="用户"+userDO.getId();
        shoppingCartDO.setUname(name1);
        shoppingCartDO.setRates(scenicspotDO.getRates());
        shoppingCartDO.setSname(scenicspotDO.getSname());
        shoppingCartDAO.insert(shoppingCartDO);
        Page<ScenicspotDO> page1=PageHelper.startPage(pageNum,10).doSelectPage(()->scenicspotDAO.findAll());
        List<ScenicspotDO> lists=new ArrayList<>();
        for (ScenicspotDO scenicspotDO1:page1.getResult()){
            scenicspotDO1.setUrls(pictureDAO.findByPid((int) scenicspotDO1.getId()));
            String name=scenicspotDO1.getSname();
            scenicspotDO1.setUr("/szx/productPager?name="+name);
            lists.add(scenicspotDO1);
        }
        ScenicspotDO scenicspotDO2=new ScenicspotDO();
        int[] ir = new int[10];
        for (int i=1;i<=page1.getPages();i++){
            ir[i-1]=i;
        }
        scenicspotDO2.setPageNum(ir);
        scenicspotDO2.setId(pageNum);
        Collections.shuffle(lists);
        lists.add(10,scenicspotDO2);
        User user1=userDO.model();
        user1.setSc(lists);
        List<ScenicspotDO> list=new ArrayList<>();
        ScenicspotDO scenicspotDO3=new ScenicspotDO();
        scenicspotDO3.setSname("无结果");
        for (int j=0;j<number;j++){
            list.add(j,scenicspotDO3);
        }
        Searchr searchr=new Searchr();
        searchr.setUser(user1);
        searchr.setList1(list);
        model.addAttribute("searchr",searchr);
        return "/homepager";
    }

    @GetMapping("/personal/shoppingCart")
    public String shoppingCart(Model model,HttpServletRequest request){
        // 取得 HttpSession 对象
        HttpSession session = request.getSession();
        UserLoginInfo userLoginInfo=(UserLoginInfo)session.getAttribute("userLoginInfo");
        UserDO userDO=userDAO.findByUserAccount(userLoginInfo.getUserAccount());
        List<ShoppingCartDO> shoppingCartDOS=shoppingCartDAO.findByUid(userDO.getId());
        User user=userDO.model();
        int m=shoppingCartDOS.size();
        List<Integer> rates=new ArrayList<>();
        List<String> name=new ArrayList<>();
        List<String> picture=new ArrayList<>();
        List<String> urls=new ArrayList<>();
        String url;
        for (int i=0;i<m;i++){
            rates.add(i,shoppingCartDOS.get(i).getRates());
            name.add(i,shoppingCartDOS.get(i).getSname());
            picture.add(i,shoppingCartDOS.get(i).getPicture());
            url="/personal/insertOrderForm?sid="+shoppingCartDOS.get(i).getSid();
            urls.add(i,url);
        }
        user.setShopname(name);
        user.setShoprates(rates);
        user.setShoppicture(picture);
        user.setUrl(urls);
        model.addAttribute("user",user);
        return "/shoppingCart";
    }
}
