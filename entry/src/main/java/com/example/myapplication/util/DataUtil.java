package com.example.myapplication.util;

import com.example.myapplication.db.*;
import ohos.app.Context;
import ohos.data.DatabaseHelper;
import ohos.data.orm.OrmContext;
import ohos.data.orm.OrmPredicates;
import ohos.data.preferences.Preferences;

import java.util.List;

public class DataUtil {

    public static OrmContext ormcontext;

    private static Preferences preferences = null;



    /**
     * 创建一个静态方法，用于初始化数据库
     * @param context
     * @return
     */
    public static OrmContext initialDataBase(Context context){
        //创建关联数据库的API对象
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        ormcontext = databaseHelper.getOrmContext("LuntanStore" , "LuntanStore.db" , LuntanStore.class);

        AddForumInit();
        AddPostInit();
        AddUserInit();
        AddCommentInit();
        AddFollowInit();
        AddSubscribeInit();

        ForumUtil.init();
        return ormcontext;
    }


    public static void AddUserInit(){
        //用户1-5
        addTuser(new Tuser("hsd","0110","黄帅迪"));
        addTuser(new Tuser("ybq","0913","羊宝泉"));
        addTuser(new Tuser("yhx","1014","羊鹤熊"));
        addTuser(new Tuser("fangod","0715","帆God"));
        addTuser(new Tuser("lsh","0000","罗圣"));
        //用户6-10
        addTuser(new Tuser("SuTerry","1234","苏Terry"));
        addTuser(new Tuser("Loppy","1217","卢比"));
        addTuser(new Tuser("lcsb","0211","绿茶"));
        addTuser(new Tuser("clh","1116","鸿哥"));
        addTuser(new Tuser("wzc","2222","体育生wzc"));
        //用户11-15
        addTuser(new Tuser("hsdhandsome","6789","帅到黄思迪一脸"));
        addTuser(new Tuser("hsdlove","8888","hsd的小宝贝"));
        addTuser(new Tuser("hsd123","3456","单纯的hsd"));
        addTuser(new Tuser("hsdfans","2468","hsd粉丝后援会"));
        addTuser(new Tuser("jntm","0802","坤坤"));
        //用户16-20
        addTuser(new Tuser("lulu","1009","不是周杰伦"));
        addTuser(new Tuser("shua","1002","少来烦姐哈"));
        addTuser(new Tuser("sunami","0106","little米"));
        addTuser(new Tuser("kong","0717","空空"));
        addTuser(new Tuser("hyw","1217","卢比女友"));
    }

    public static void AddForumInit(){
        addForum(new Forum("汽车吧","女人开车是为了享受，男人开车是为了征服","392485",0));
        addForum(new Forum("足球吧","只要心脏在跳动，就不会舍弃脚下滚动的足球","325681",1));
        addForum(new Forum("篮球吧","最新鲜的篮球资讯和当下最热的篮球话题","458924",2));
        addForum(new Forum("爱情吧","遇事不决就来爱情吧，恋爱婚姻中的那些问题总有吧友帮你解决","124098",3));
        addForum(new Forum("崩坏：星穹铁道吧","本吧为《崩坏：星穹铁道》玩家交流贴吧","296293",4));

    }

    public static void AddPostInit(){
        //汽车吧的帖子
        addPost(new Post("22款帕美提车日记",
                "有的没的配置都被选上了，真羡慕铂金版的车友，当时其实是去看卡宴的，因为家里有辆小白，SUV也有，想着再买个卡宴。午夜蓝虽然颜色不显眼，晚上看着就像黑色，个人觉得挺有质感，好比穿西装的低调绅士，骚就完事了。当时提车马上过年，4S人没人加上还在装修，定制鲜花没有，场地就这样凑合吧。我自己找了个验车，因为以前买车遇到过不愉快的事，打官司大半年才把事情解决，所以有条件的话还是找个验车的，自己花钱买个心安，说不准还能中个大奖。希望能遇到更多志同道合的兄弟们。",
                1L,1L,0,"30224","1763"));

        addPost(new Post("大家说说一台好车对一个做生意的家庭来说重要吗",
                "我发现我们身边一些个规模和经济实力远远不如我们的工厂主开的都是比较不错的车，比如说有个工厂主，他的资产仅仅是我们家的1/4还不到，他的工厂规模还不到我们家的1/7 ，但是他却开了一个70万的宝马X5，而我们家只有个14万的车，我就开始意识到我们家缺一台好车，大家觉得一台好车对一个做生意的家庭来说重要吗？",
                4L,1L,1,"1349","874"));
        addPost(new Post("『暴力美学』C63 AMG 提车作业",
                "选车过程很简单，100W这个价位其实可以选择的车也没多少。比如宝马的M3M4，奥迪的rs5，玛莎的小G这样子。主要是想着要四门，有外观有实力，平时可以开着去见客人，无事可以和电瓶车飙飙车什么的，于是在筛选的过程中很容易的就排除了M4和RS5了。不选择M的理由是觉得新的一代宝马M把自吸变成了涡轮，同时在车里面增加了一个模拟声浪，就是你给油的时候，车内音响会发出一种自吸发动机特有的那种打鼓式的声浪，我仔细听了听，居然还有降档补油的声音，我瞬间觉得一万多只羊驼在心头潇潇洒洒，不说别的，到了这个价位，声浪你居然还要靠模拟？本身就对宝马不感冒，现在更不感冒了。",
                2L,1L,2,"22896","7673"));
        addPost(new Post("开着帅领克上下班",
                "我的车是2023款2.0T劲pro，截止目前已经跑了5000公里，优缺点都有，总体下来还是挺满意的，领克并没有让我失望，开着他上下班、跑工地。我上下班及出差都开它，相对于其他日系德系车会费油一点，但是可以接受，而且它给你的安全感和动力表现是其他同等价位车给不了的。车子走到哪都会给人很帅气的感受，上下班以及在路上行驶姿态我觉得很帅前两天拉材料不小心把后排出风口卡扣碰掉了，左侧还擦到了路中间的保护杆，有点心疼，不是很严重，打磨抛光一下应该就可以了，大家日常开车注意安全，小心驾驶，也祝大家会像有些楼主那样早日找到女朋友，我也加油。",
                7L,1L,3,"3025","230"));
        addPost(new Post("电车比油车领先在哪里？",
                "现在买电车的人越来越多，电车也是未来趋势，最近想考虑买车就去看了model 3、蔚来et5、宝马4系和奔驰c260l，试驾之前最中意的是蔚来et5，但是当真的试驾过后觉得蔚来车机没有带来非常智能化的感觉，内饰对于我个人的审美来说过于简单了，把所有功能都集中到大屏幕里并不是那么的实用，开车的时候需要调整设置也非常不方便。反而刚开始不考虑的奔驰c260l是让我最满意的，内饰精美优雅，该有的功能也都有，虽然是1.5T但百公里加速8秒左右也完全够用，电车能做到百公里加速4秒左右，但是实际上大部分人都是把动力调整到6、7秒左右的舒适模式，过快的加速司机或者乘客都会觉得不舒服。\n" +
                        "电车领先油车的地方，我目前只想到下车不用锁车关窗，人走远了会自动关窗锁门，平时在车上等人的时候不用熄火，可以一直开着空调也不用担心发动机积碳。\n",
                10L,1L,4,"3348","204"));

        //足球吧的帖子
        addPost(new Post("狼队对阵切尔西前瞻，蓝军状态不佳客场恐遭败绩",
                "兄弟们，如果你是狼队或者切尔西的球迷，那4月8号晚上22.00的狼队对阵切尔西的这场比赛那肯定千万不要错过。对于两支球队来说，本赛季都是比较失望的一个赛季。两支球队本来按照纸面实力来说都应该排在英超上游积分榜，可是我们擦亮眼睛一看，两支球队目前的排名非常辣眼，狼队甚至还要参加接下来的保级战。而切尔西虽然不用为降级担忧，可蓝军这个赛季已经没有参加下赛季欧冠联赛的希望，甚至连一个欧联杯都基本上捞不到，不过也好，切尔西下赛季虽然很大可能无法参加欧战，但是一个赛季减少了不少的比赛，也能让球员们能保持更好的身体健康以便磨合球队现有的阵容。\n" +
                        "\t狼队这几个赛季其实表现的非常的不理想，球队其实在阵容上不差，球员的身价在英超来说都是属于中上游的价格，可是这批球员并没有打出符合自己身价的成绩，特别是狼队阵中有不少葡萄牙现役国脚以及其他国家队的国脚球员，照理来说狼队是为了欧战资格而努力，而不是到目前要去进行保级战。\n" +
                        "切尔西本赛季也是风雨飘零，按理来说球队虽然换了新老板，但是新老板也舍得给球队姻缘，带来了恩佐、穆德雷克等强援，这些球员都花费了俱乐部不菲的引援资金，可是切尔西的成绩却是一再跌落，可以说，切尔西目前的阵容是失败的。而切尔西最近炒掉了波特，这是本赛季切尔西炒掉的第二名主教练，没有一个稳定的教练团队，切尔西的球员又很难短时间适应新教练的打法。\n",
                1L,2L,5,"2455","294"));
        addPost(new Post("哈里凯恩要是能来我仁就好了",
                "哈里凯恩到底为什么对热刺这么忠诚?已经够可以了，为啥还不走，我仁就缺一个好的中锋，在热刺这样的烂队都能30球，来我仁，不可能输给曼城的，机会很多，就缺一个能进球的。",
                8L,2L,6,"526","60"));
        addPost(new Post("这你明摆着就是不让你进球",
                "判越位视频看两个点，一个是传球人起脚的瞬间，一个是起脚瞬间接应人员是否越位，如果在毫厘之间的话这个操作就很多了，想判你越位就把起脚瞬间拉晚甚至球离脚后才开始算。不想判就把球离脚瞬间拉早甚至拉倒刚触球的瞬间！视频裁判绝对有问题，马宁在这种情况下不自己看视频也有问题！",
                12L,2L,7,"5562","382"));
        addPost(new Post("瓜迪奥拉并非只是想截胡赖斯,是真想让他取代京多安",
                "The Athletic UK曼城跟队记者Sam Lee撰写专栏文章，文章的标题是——Guardiola wants Declan Rice to replace Gundogan not Rodri, but he’d need to learn ‘pausa’专栏中明确指出：\n" +
                        "赖斯是曼城追逐的目标，以取代伊尔凯-京多安，这表明曼城并不仅仅把他当作一名拖后中场。当然，如果罗德里需要休息，他们可以让他担任这个角色，但他们相信他可以胜任中场的任何位置，就像京多安一样。也许一开始不是那么天衣无缝，但肯定有潜力做到这一点。事实上，在瓜迪奥拉的战术思想中，科瓦契奇也是如此。\n" +
                        "比起更擅长短传的京多安，科瓦契奇和赖斯更喜欢带球跑动，而赖斯尤其擅长在中前场两线之间直接传球。他们都没有京多安那么全面，但是如果他们下赛季都在阿提哈德球场，他们将被要求适应，在某种程度上，曼城也会去适应他们。\n" +
                        "瓜迪奥拉计划下赛季坚持四中卫的战术，而不是签下传统的边后卫，这通常意味着斯通斯再次重返本赛季的中场定位。这也意味着曼城有一个稳固的后防线，这意味着如果他们相对缺乏控球能力（就像上赛季他们适应哈兰德时的情况一样），他们至少有很好的中后场人员配置来应对潜在的反击。\n" +
                        "随着时间的推移，科瓦契奇和赖斯（如果后者真的加盟）将会更好地理解如何控制比赛，以及如何在球场的不同区域进行布置——在更拖后的区域更加小心控球，在进攻三区承担更多的风险——但他们也将能够发挥自己的优势，曼城相信他们可以像京多安那样贡献进球。但无论结果如何，很明显，曼城在这次出价中考虑的不仅仅是想把赖斯从阿尔特塔的手中夺走。只是不管怎样，阿森纳还是有可能签下他。\n",
                11L,2L,8,"3657","254"));
        addPost(new Post("国际米兰：欧冠，欧联连续两个亚军，到底问题出在哪？",
                "在这个金元足球的时代，在俱乐部如此负重前行的今天，我们可以接连的站在欧联欧冠的决赛赛场，难道还不是成功？而挥舞着钞票，已经算是统治英超多年，金元足球时代最具代表的曼城，也仅仅在今天，还不是那么信服的，首次拿到欧冠，相比之下，小国际能走到今天，并打出这样的比赛，再个人看来，难能可贵的太多了。",
                16L,2L,9,"10254","2650"));

        //篮球吧的帖子
        addPost(new Post("你认为哈登与快船的适配度如何",
                "根据记者Sam Amick的报道，根据内部消息人士透露，哈登想要加盟快船。另有消息人士透露，伦纳德和乔治都支持哈登加盟快船，与哈登并肩作战。目前洛杉矶快船的总薪资为1.912亿，位列全联盟第一。奢侈税为1.403亿，位列联盟第二。哈登下赛季的合同为3562万一年。目前快船阵中主力球员有伦纳德、乔治、鲍威尔、威少（自由球员）、特伦斯-曼、戈登、祖巴茨和莫里斯等。",
                15L,3L,10,"3420","626"));
        addPost(new Post("方硕放弃顶薪，愿意用老将底薪续约北京队",
                "记者30日获悉，北京男篮已经与33岁的方硕已经达成了老将合同的续约协议。方硕上一份合同是顶薪合同，当时也全队唯一一个顶薪球员。在2022-23赛季结束后，方硕面对续约谈判时表达的明确态度是，他希望继续在北京男篮效力，“续约首钢永远是我的第一选择”。同时北京男篮也很希望留住这个球队的核心。据了解，双方在续约谈判过程中是顺利的，他们在大方向上始终保持一致。而对于方硕而言，他已经符合了老将合同的签订标准，由顶薪合同变为老将合同，必定在收入上会有所降低，但这也是方硕为了球队做出的自己“牺牲”。对于北京男篮而言，方硕变为老将合同，他的基本工资不计入球队工资帽，在新赛季球队整体工资帽下降的背景下，这有利于球队后续的签约与引援。",
                9L,3L,11,"459","23"));
        addPost(new Post("凯尔-安德森有望7月中下旬与中国男篮汇合，8月参加热身赛",
                "如果一切手续办理顺利的话，那么李凯尔有望在七月中下旬与中国男篮会合，然后可以与全队一起出战8月在深圳打响的热身赛。全部完成后，李凯尔将与中国男篮一起出战世界杯。",
                9L,3L,12,"4452","218"));
        addPost(new Post("媒体人称为发展东北周琦应加盟辽宁，周琦留言回怼",
                "近日媒体人“兰音之因”在社媒发长文，表示为了东北发展建设，非常期待周琦加盟辽宁男篮。 周琦本人留言回应：“你说我有这么大能耐振兴经济，俄乌冲突要不我也去？” “兰音之因”回应：“你太高看自己了。我说的是辽宁队。你现在能代表辽宁男篮不？即便你有一天代表辽宁男篮，你能代表辽宁父母官发展辽宁的决心不？这么矫情吗？还是多读读书吧，打球的人都挺聪明，没想到有你这么个意外。”",
                12L,3L,13,"108","12"));
        addPost(new Post("广工复仇清华，CUBAL最好的故事属于向上的少年",
                "一年前，在板凳上看着广东工业大学被清华大学击败，陈国豪没有哭；一年后，广工87-83复仇清华，夺下CUBAL冠军的陈国豪再也忍不住了，泪水夺眶而出。最好的篮球装点青春的舞台，最好的故事属于向上的少年。",
                13L,3L,14,"1243","201"));

        //爱情吧的帖子
        addPost(new Post("相亲遭遇难题，身高重要吗",
                "本人178，年龄26。前段时间家里人介绍了一位02年的女孩认识。因为没在一个地方工作，互相交换了照片，并且视频电话了，双方都还满意，此时女生自己说身高在152左右。自己在家拿尺子比划了下，肩膀附近 ，可以接受。\n" +
                        "于是双方热聊了半个月，约了今天面基。我坐了十个小时的车回老家找她。然后今天见面了，感觉离肩膀还差一截呢，估计只有145左右。\n" +
                        "现在小弟就比较难接受了，身高差的实在太多，一开始也没有说明这个情况。但是妹子性格的确很好，很能处的来。",
                20L,4L,15,"3310","209"));
        addPost(new Post("这算门当户对吗",
                "哥们和他女朋友感情挺好，今天聊起来说是准备见父母，有点底气不足，来街上看看大家看法。女方属于没啥大目标那种，每天吃吃喝喝开开心心的就行，不是很作。家人们评论区给给看法。",
                18L,4L,16,"108","17"));
        addPost(new Post("男人一定要有香水",
                "去机构上考公课，那天出门也不知道为啥就喷了两下香水，机构前门没车位了我就停后门然后从后门走，正巧她在后门背书，哥们从旁边路过当时也没注意到，后面她故意制造了几次偶遇然后就加上微信开始了。",
                8L,4L,17,"295","48"));
        addPost(new Post("大家怎么就不愿意结婚了",
                "民政部近期公布的数据显示，2022年我国结婚登记数为683.3万对，较上一年减少约81万对。该数据更是创下1986年民政部有相关数据记录以来的新低，我国结婚登记数也已呈连续9年持续下降状。大家为啥不结婚了？",
                20L,4L,18,"339","105"));
        addPost(new Post("跨阶级的恋爱能不能谈",
                "跨阶级的恋爱，能不能谈，谈好了是泰坦尼克号的杰克和rose，谈不好就是这部悲剧电影的男女主。说到底还是要看人品，选择跟怎样的人过完余生，但上限又是很难预测的，能把控的是最基础的下限，那就是健康和善良。如果没有这两样，一切都是空谈。家庭，颜值，经济，学历都是身外之物而已。无论男女，谈恋爱前，走进婚姻前，清醒而理智的规避一些难以改变的现实，人生才能少走一些弯路吧。",
                15L,4L,19,"1036","87"));

        //星穹铁道吧的帖子
        addPost(new Post("回合制确实无聊",
                "他出角色的速度，比我养成角色的速度快多了。上个月几乎都是在打行迹材料，信用点不出5位数，懒的搞了，每次更新花半天回来看个剧情。玩来玩去也就那样，等绝区零出来，不玩了。",
                4L,5L,20,"142","78"));
        addPost(new Post("说句实话，我的65景元快要仓管了",
                "\tBox如图，目前几个限定最后悔的就是景元的命座，提升真的太小了，0+1景元真的完全体。\n" +
                        "\t现在我打深渊用65姬子（带的精5拂晓）比65景元舒服很多。虽然不知道为什么姬子风评那么差，但是65姬子真的很舒服至少我用的比景元舒服。可能姬子强度在命座里。\n" +
                        "\t另一队基本是希儿了，景元这个角色0+1真的接近完全体，后面再抽提升也很小。就算凹0t竞速景元也是非常弱势，雷弱凹个三人，雷抗6+5也得4人拉满。说白了真是常驻的水平。（个人看法，欢迎讨论）\n",
                10L,5L,21,"548","414"));
        addPost(new Post("罗刹和老杨什么关系",
                "没玩过崩坏的其他作品，不用担心给我剧透，大概率也不想玩了，感觉根本打不过大佬",
                12L,5L,22,"6742","3781"));
        addPost(new Post("罗刹光锥千万别选这两个",
                "罗刹光锥避坑一：娜塔莎卡面《术后对话》不适合，这个众所周知，罗刹大招是伤害不是加血，大招治疗量增加等于没有，极度不推荐；避坑二：克拉拉卡面《同一种心情》这个看似战技又加治疗量又能全队回能，实际上仅仅只对罗刹主动释放战技的时候有效，其他时候诸如50%以下自动回血，结界回血都是无法触发此效果的，而罗刹实战中很少主动释放战技，因此此光锥几乎等于白板！这个光锥太多主播和up主推荐了，千万别信，就是个大坑。这里推荐一下罗刹最适配光锥：一是专武《棺的回响》，这个毋庸置疑；除此之外最好的四星为《等价交换》极大增加了辅助能力，很不错；当然，你有白露专武也可以使用，面板好看一些(｡･ω･｡)ﾉ♡",
                13L,5L,23,"6548","4860"));
        addPost(new Post("等1.2送一只驭空了",
                "有无大手子测过，6魂御空好用不，能和谁搭",
                20L,5L,24,"413","311"));
    }

    public static void AddCommentInit(){
        //汽车吧中帖子的评论
        addComment(new Comment(3L,"恭喜，我下个月提车",1L,35));
        addComment(new Comment(7L,"拉我进车友群吧，我说不定下辈子能提一辆",1L,55));
        addComment(new Comment(10L,"富哥v我50",1L,100));
        addComment(new Comment(13L,"做梦都想拥有啊 楼主牛逼啊", 1L,5));
        addComment(new Comment(5L,"90老大哥，毕业多年才努力的搞了个小套三一个glc 一个奥迪A3，梦里都想上保时捷",1L,20));

        addComment(new Comment(6L,"重要！接触的温州工厂老板的原话：开厂第二年不换豪车的话人家都不让你欠款。",2L,51));
        addComment(new Comment(9L,"农村吃席，同样是来晚了，我只能等着吃第二轮，开奔驰的立马给加一席。",2L,20));
        addComment(new Comment(13L,"牛批吹上天有啥用，先v50万来证明实力。",2L,87));
        addComment(new Comment(15L,"客户生意人现实得很，优先看你厂子实力，查查你厂子口碑，最后看你车子。",2L,32));
        addComment(new Comment(8L,"有余钱可以换，但靠车撑生意圈的门面怕是不好用了。不是以前那年头了。陌生人看你一台车就信你家底了？更别说熟人了。这几年做项目认识好几个小老板，感觉还是办事靠谱对生意帮助最大。", 2L,21));

        addComment(new Comment(1L,"然而车主里面的内饰是芭比娃娃的内饰",3L,28));
        addComment(new Comment(5L,"磨砂黑色更吊炸天",3L,152));
        addComment(new Comment(6L,"还是觉得以前的6.2 V8自然吸气有趣，不过新款也很漂亮，恭喜楼主",3L,62));
        addComment(new Comment(9L,"这车是我的最爱。但是买不起。下辆车我要买CLA45",3L,99));
        addComment(new Comment(3L,"这车真的好，63都是好车，虽然我一辆都买不起",3L,33));

        addComment(new Comment(5L,"恭喜，虽然我欣赏不来这个外观，但是自己的车就是最好的。", 4L,256));
        addComment(new Comment(11L,"03帅的，尤其是屁股尾灯，简直太帅了。",4L,94));
        addComment(new Comment(14L,"23款车友你好，我是21款的。", 4L,88));
        addComment(new Comment(3L,"帅，就是坐着有点儿难受，贼硬。", 4L,152));
        addComment(new Comment(6L,"好看，希望我也能早日提车。", 4L,163));

        addComment(new Comment(3L,"电车主要就是城内通勤代步，非发达地区现在中长途电车还是不太方便。特别是家里没有充电桩又赶时间的时候。", 5L,165));
        addComment(new Comment(2L,"领先在免购置税，不要摇号，不会限行。", 5L,26));
        addComment(new Comment(5L,"主要还是电机相对壁垒没有那么高，绕过了内燃机的调教，并且电车主机厂都是互联网思维，给配置智能化水平都高，使得电车内部使用的科技感会高于油车，还有就是能源使用费用相对低廉，这些优点吧", 5L,92));
        addComment(new Comment(15L,"更多的感觉电车许多功能都是为了看起来智能化而智能化，比如门把手感应弹出多此一举的感觉，油车直接拉开门把手就行", 5L,64));
        addComment(new Comment(12L,"让像我这种穷B也可以体验超级跑车那种快人一步的驾驶感觉", 5L,230));

        //足球吧中帖子的评论
        addComment(new Comment(15L,"感觉切尔西1点希望都没有啊！！", 6L,20));
        addComment(new Comment(13L,"目前狼队的实力也是很可观的", 6L,12));
        addComment(new Comment(19L,"从来都不去重视管理层的问题！", 6L,26));
        addComment(new Comment(17L,"总的来说，两队的实力差距还是很悬殊的", 6L,82));
        addComment(new Comment(4L,"目前狼队还是要需要参加接下来的保级赛", 6L,13));

        addComment(new Comment(14L,"还惦记着英超射手王这个记录吧", 7L,3));
        addComment(new Comment(13L,"来了不一定好用 户口本第一是贵 第二水土不服", 7L,66));
        addComment(new Comment(17L,"他不离开英格兰我可以理解，不离开热翔我是真理解不了哪怕去纽卡这种新兴豪门都好，今年有决赛踢呢", 7L,35));
        addComment(new Comment(11L,"年纪大了", 7L,126));
        addComment(new Comment(10L,"不符合球队文化，价格高年龄大薪资贵", 7L,22));

        addComment(new Comment(5L,"我也有同样的疑惑，转播镜头里最后给越位划线的定格貌似就是往后延了一下", 8L,20));
        addComment(new Comment(6L,"再说一次，越位球主裁判可以不看，可以完全听视频裁判的。这球就是视频裁判黑", 8L,53));
        addComment(new Comment(11L,"楼主的意思是 你看到的那个定格画面 没准球已经离开脚了", 8L,10));
        addComment(new Comment(20L,"合着你们倒霉撞枪口上了 知道为什么嘛 因为海港领先优势只有一分了 不黑你们怎么办呢", 8L,4));
        addComment(new Comment(1L,"马宁应该是没什么毛病，如果有早进去了", 8L,13));

        addComment(new Comment(2L,"这两个赛季最后阶段的京多安，很难有人替代", 9L,125));
        addComment(new Comment(3L,"支持瓜帅", 9L,39));
        addComment(new Comment(12L,"瓜瓜不错，还帮忙抬价，多抬抬", 9L,12));
        addComment(new Comment(16L,"科瓦也是个搞笑的人，有一场专门盯防梅西，面对眼前机会更好的其他人不管，奔着梅西去了，结果就丢球了", 9L,4));
        addComment(new Comment(8L,"有的球员很凶，有的球员很稳，科瓦是凶中带着稳，稳中透着凶。不是特别要，随意都很凶。这笔交易太值啦。", 9L,95));

        addComment(new Comment(1L,"不讨论阵容厚度的情况下，就临场发挥而言，一个折在裁判，一个折在运气，如果综合讨论就是意甲没钱，别人牌多", 10L,136));
        addComment(new Comment(4L,"球队体量不够！阵容单薄，球员老弱太多，同质化严重，球队只能用一种打法，技不如人就只能靠笨方法踢球！", 10L,85));
        addComment(new Comment(14L,"欧联那个亚军有点扯，这个就算了。只是我们运气不够，不像当年利物浦从伊斯坦布尔翻身，开启了复兴之路罢了。", 10L,66));
        addComment(new Comment(12L,"实力阵容都差，换贝拉诺瓦，丹布这种完全不能期待的球员，这样根本不可能在决赛赢球", 10L,235));
        addComment(new Comment(18L,"赛季前 有人敢说国米争欧冠？大牙都能让人笑掉 赛前也没人看好国米…人家曼城花多少钱，你小国际花多少钱。不花钱，不投入凭啥都让你拿啊？还真以为要像隔壁一样靠个dna啊", 10L,54));

        //篮球吧中帖子的评论
        addComment(new Comment(2L,"这三个人最大问题不是下滑，毕竟下滑也是跟巅峰得自己比，问题是健康，三个人同时完整打完一个赛季得机率有多少。", 11L,82));
        addComment(new Comment(9L,"难说，篮网三巨头一起打了16场，哈登过去能破这个记录吗？", 11L,15));
        addComment(new Comment(10L,"哈登自从去了篮网和76人改主打控卫，进攻欲望下降不少。和卡椒在一起应该也不会出现球权问题，除了拉开空间，对手也不敢放哈登。理论上挺适配", 11L,63));
        addComment(new Comment(1L,"完美适配，胡子常规赛放开抡，卡椒穿西装看着，季后赛卡椒抡，胡子穿西装看，突出一个扬长避短", 11L,65));
        addComment(new Comment(6L,"这仨比起来，反倒是哈登最健康了", 11L,88));

        addComment(new Comment(1L,"一名老将的胸怀和责任感", 12L,22));
        addComment(new Comment(4L,"他真的，我哭死", 12L,66));
        addComment(new Comment(2L,"我硕哥瑞思拜！真正的一人一城！俱乐部引援给点力吧，别辜负了我硕哥！", 12L,98));
        addComment(new Comment(7L,"在cba这种球员流动性极低的联赛，每个球队都应该有这种球员", 12L,25));
        addComment(new Comment(14L,"就看上赛季的表现，外援的钱给他都不亏", 12L,45));

        addComment(new Comment(5L,"好！终于要等到李凯尔同志了！", 13L,152));
        addComment(new Comment(10L,"首次亮相就在老家深圳", 13L,59));
        addComment(new Comment(15L,"世界杯跟周琦一起给五花肉上上对抗，希望比跟法棍一起防的好", 13L,96));
        addComment(new Comment(3L,"要是热身赛和世界杯周琦能给约老师造成一点麻烦，说不定又能去NBA了", 13L,12));
        addComment(new Comment(11L,"进了深圳的族谱，户口在上海，李凯尔只跟大城市玩", 13L,85));

        addComment(new Comment(10L,"兰音这水平，也好意思叫别人读书？", 14L,2));
        addComment(new Comment(2L,"是个人注册个微博都是媒体人 我微博是黄V体育博主 我也是媒体人了呗", 14L,15));
        addComment(new Comment(5L,"她就是性格脑子不太正常，全世界都烦她，她都不思考自己的问题。都觉得别人欺负她", 14L,59));
        addComment(new Comment(14L,"她和翟晓川吵架，连权利和义务都分不清，我怀疑她连初中都没毕业", 14L,13));
        addComment(new Comment(15L,"怼的好", 14L,12));

        addComment(new Comment(15L,"活和篮球里最美好的事情其实常常不是成功本身，而是有一群和你一起奔向成功的人，有一群带着你的梦想成功的人。", 15L,252));
        addComment(new Comment(6L,"广工球员的肤色和肌肉，就知道平时训练多刻苦", 15L,52));
        addComment(new Comment(8L,"今年打不过你，我就拼命练。身高不如你，我就死命冲击。这才是篮球该有的样子，这才是青春该有的样子！恭喜广工！", 15L,35));
        addComment(new Comment(11L,"平日就是以赛代练，球员们各地去打比赛，队员们之间各种排列组合，有时省联赛不在一个队，市联赛又在一个队。", 15L,95));
        addComment(new Comment(1L,"前晚我孩子说，两支球队的肌肉，清华像健身房，广工像建筑工地，把我给整笑了", 15L,44));

        //爱情吧中帖子的内容
        addComment(new Comment(16L,"太矮了，如果是本来有感情还好，相亲的话还是找个正常身高吧，对孩子好…", 16L,34));
        addComment(new Comment(12L,"说实话，这个身高不建议你谈了。父母的身高对遗传影响还是很大的，特别是母亲。", 16L,28));
        addComment(new Comment(5L,"也要为后代着想一下吧    到时候你儿子一米六  女儿一米五   双双找不到对象    你是否会后悔现在的决定？", 16L,21));
        addComment(new Comment(10L,"这事只能自己判断…真觉得人不错就接触接触先。", 16L,16));
        addComment(new Comment(19L,"如果一开始就介意，建议不要继续。可以找个其他的理由当借口拒绝吧……", 16L,10));

        addComment(new Comment(16L,"挺般配，都是体系里面", 17L,23));
        addComment(new Comment(2L,"家庭不如女方，但是工作很好，老丈人余威尚在，可以提供帮助", 17L,17));
        addComment(new Comment(5L,"略高攀吧，厅级干部的圈层确实不太一样，我家孩子同学，爷爷是副厅，都不一样的场", 17L,14));
        addComment(new Comment(17L,"现在都表格结婚吗？", 17L,11));
        addComment(new Comment(13L,"你们是怎么问到这些条件的，我都不好意思问。", 17L,7));

        addComment(new Comment(2L,"俺来说实话，跟香水没关系你小子一定是长的有点小帅", 18L,48));
        addComment(new Comment(14L,"香奈儿蔚蓝或者宝格丽大吉岭茶，这俩很稳基本不会出错，买淡香的就行。", 18L,35));
        addComment(new Comment(20L,"什么香水，这么神奇", 18L,23));
        addComment(new Comment(16L,"我用的sixgod，特别穿白衬衣喷一点，招蜂引蝶嘎嘎的", 18L,18));
        addComment(new Comment(9L,"好的香水对男生绝对是加分项。", 18L,10));

        addComment(new Comment(6L,"有些是眼光太高，找不到满意的。反正原因多种多样。", 19L,37));
        addComment(new Comment(9L,"结了，想离，但是有孩子了，惨", 19L,35));
        addComment(new Comment(7L,"结婚倒是愿意就是不愿意生小孩", 19L,29));
        addComment(new Comment(12L,"这个月出差去了东南亚，虽然那边经济不如国内，但是感受就是我们生活太卷了，活的太累，幸福感还不如马来西亚", 19L,20));
        addComment(new Comment(13L,"客观的讲就是生活和育孩等观念变了呗，很多人说没钱所以不结，难道以前的人都更有钱吗？", 19L,12));

        addComment(new Comment(10L,"可以谈，喜欢就去追！在一起过也是一段美好人生经历！不过。。甜了以后也要承受很多倍的苦", 20L,85));
        addComment(new Comment(18L,"也许类比爱而不得的遗憾，这种阶级差距过大的关系，甚至都不能让人想去开始。", 20L,70));
        addComment(new Comment(4L,"阶级矛盾一直都存在，恋爱里，不全是幸福，充满了各式的悲剧罢了。", 20L,56));
        addComment(new Comment(8L,"相遇就是缘，可是时间久了呢？", 20L,32));
        addComment(new Comment(9L,"精神与物质上的差异，吞噬着彼此的新鲜感，很快就见底了。", 20L,24));

        //星穹铁道吧中帖子的内容
        addComment(new Comment(6L,"绝区零如果继续给你整换皮原神呢", 21L,5));
        addComment(new Comment(7L,"其实绝区零，才没意思，这里面最起码还都是女的人类。", 21L,12));
        addComment(new Comment(14L,"绝区可能要当成主游玩", 21L,18));
        addComment(new Comment(3L,"本来二游就是这样的，闲暇时间玩一玩。你平时没点别的事可以干了么，只能盯着手机玩？", 21L,2));
        addComment(new Comment(10L,"可以挂机啊", 21L,34));

        addComment(new Comment(3L,"你玩的是破解版吗", 22L,13));
        addComment(new Comment(5L,"不具备普遍参考意义", 22L,15));
        addComment(new Comment(19L,"是难受依赖神君出手跑的又慢的要命，我打算练黑塔把专武给她了", 22L,26));
        addComment(new Comment(20L,"还是看环境吧，都有环境不好的时候", 22L,8));
        addComment(new Comment(12L,"这期八九十一半雷抗怪纯纯恶心景元，感觉目前限定和常驻c没有质的区别，抗性+弱点一来一回40%的差距，六个命座都补不上", 22L,19));

        addComment(new Comment(15L,"目前来看没啥关系，只是罗刹这张脸长得像老杨的一个杀父仇人而已。", 23L,15));
        addComment(new Comment(2L,"奥托杀了瓦尔特他爹，他老师，他朋友，差点杀了他自己，罗刹和奥托长着一张脸", 23L,19));
        addComment(new Comment(5L,"瓦尔特看到罗刹回忆的那几张脸是虚空万藏 虚空万藏曾在列车上和瓦尔特一起旅行 结果半路跳车走了 虚空万藏用的隔壁崩三奥托的脸 就这么简单", 23L,23));
        addComment(new Comment(8L,"老杨:都长这个样子了还能是好人？", 23L,55));
        addComment(new Comment(4L,"虽然我杀了你叠但是你可以把我当你的新叠呀", 23L,24));

        addComment(new Comment(10L,"同一种心情如果不能触发的话我觉得可以考虑当bug上报了", 24L,125));
        addComment(new Comment(6L,"确实", 24L,68));
        addComment(new Comment(7L,"是的，害的我把同一种心情拉满，吃了好多狗粮。现在等价交换都拉不满了。。。", 24L,88));
        addComment(new Comment(16L,"确实，看到好多主播推荐这俩是真的不理解", 24L,42));
        addComment(new Comment(17L,"术后能用，但是要4精以上，可以缩轴。", 24L,26));

        addComment(new Comment(18L,"不好用。和克拉拉搭。buff容易给到同协奶盾身上。需要配速。我不愿意动脑，情愿上银狼佩拉停云布洛妮娅艾丝妲", 25L,95));
        addComment(new Comment(16L,"比主c快一点就行，速度数字比下大小，要啥脑子", 25L,26));
        addComment(new Comment(7L,"克拉拉彻底赢麻了，看似深渊环境和角色池都跟克拉拉无关，但是实际用起来是真爽啊", 25L,42));
        addComment(new Comment(11L,"要配速的，6魂开大在C位回合开就行", 25L,93));
        addComment(new Comment(1L,"目前除了克拉拉也就希儿还好用些 希儿有平a加速 乱轴后可以自己调位子", 25L,11));

    }

    public static void AddFollowInit(){
        addFollow(new Follow(1L,2L));
        addFollow(new Follow(1L,3L));
        addFollow(new Follow(1L,4L));
        addFollow(new Follow(1L,7L));
        addFollow(new Follow(1L,10L));
        addFollow(new Follow(1L,11L));
        addFollow(new Follow(1L,19L));

        addFollow(new Follow(2L,5L));
        addFollow(new Follow(2L,1L));
        addFollow(new Follow(2L,3L));
        addFollow(new Follow(2L,6L));
        addFollow(new Follow(2L,8L));
        addFollow(new Follow(2L,10L));
        addFollow(new Follow(2L,15L));
        addFollow(new Follow(2L,18L));

        addFollow(new Follow(3L,1L));
        addFollow(new Follow(3L,6L));
        addFollow(new Follow(3L,10L));
        addFollow(new Follow(3L,19L));


        addFollow(new Follow(4L,5L));
        addFollow(new Follow(4L,1L));
        addFollow(new Follow(4L,3L));
        addFollow(new Follow(4L,7L));
        addFollow(new Follow(4L,9L));
        addFollow(new Follow(4L,12L));
        addFollow(new Follow(4L,13L));
        addFollow(new Follow(4L,19L));

        addFollow(new Follow(5L,2L));
        addFollow(new Follow(5L,1L));
        addFollow(new Follow(5L,3L));
        addFollow(new Follow(5L,7L));
        addFollow(new Follow(5L,9L));
        addFollow(new Follow(5L,12L));
        addFollow(new Follow(5L,17L));
        addFollow(new Follow(5L,18L));


        addFollow(new Follow(6L,5L));
        addFollow(new Follow(6L,1L));
        addFollow(new Follow(6L,3L));
        addFollow(new Follow(6L,7L));
        addFollow(new Follow(6L,9L));
        addFollow(new Follow(6L,12L));
        addFollow(new Follow(6L,13L));
        addFollow(new Follow(6L,19L));

    }

    public static void AddSubscribeInit(){
        addSubscribe(new Subscribe(1L,1L));
        addSubscribe(new Subscribe(1L,3L));
        addSubscribe(new Subscribe(1L,5L));
        addSubscribe(new Subscribe(2L,2L));
        addSubscribe(new Subscribe(2L,4L));
        addSubscribe(new Subscribe(2L,5L));
        addSubscribe(new Subscribe(3L,1L));
        addSubscribe(new Subscribe(3L,2L));
        addSubscribe(new Subscribe(3L,5L));
        addSubscribe(new Subscribe(4L,1L));
        addSubscribe(new Subscribe(4L,4L));
        addSubscribe(new Subscribe(5L,1L));
        addSubscribe(new Subscribe(5L,5L));
    }


    /**
     * 添加 post
     * @param post
     * @return
     */
    public static boolean addPost(Post post){
        ormcontext.insert(post) ;
        return  ormcontext.flush() ;
    }

    /**
     * 得到所有post
     * @return
     */
    public static List<Post> getPosts() {
        OrmPredicates ormPredicates = ormcontext.where(Post.class) ;
        return ormcontext.query(ormPredicates) ;
    }

    /**
     * 根据ID值得到当前post
     * @return
     */
    public static Post getPost(long id) {
        OrmPredicates ormPredicates = ormcontext.where(Post.class) ;
        //添加过滤条件
        ormPredicates.equalTo("post_id" , id) ;
        //调用query方法完成登录功能
        List<Post> posts = ormcontext.query(ormPredicates) ;
        if(posts == null || posts.size() == 0){
            return  null ;
        }
        return posts.get(0) ;
    }

    /**
     * 添加follow
     * @param follow
     * @return
     */
    public static boolean addFollow(Follow follow){
        ormcontext.insert(follow) ;
        return  ormcontext.flush() ;
    }

    /**
     * 删除A关注B的follow数据
     * @param A_id
     * @param B_id
     * @return
     */
    public static List<Follow> deleteFollow(long A_id,long B_id){
        OrmPredicates ormpredicates = ormcontext.where(Follow.class);
        ormpredicates.equalTo("A_id",A_id);
        ormpredicates.equalTo("B_id",B_id);
        ormcontext.delete(ormpredicates);
        ormcontext.flush();
        return ormcontext.query(ormpredicates);
    }

    /**
     * 得到所有 follow
     * @return
     */
    public static List<Follow> getFollows() {
        OrmPredicates ormPredicates = ormcontext.where(Follow.class) ;
        return ormcontext.query(ormPredicates) ;
    }

    /**
     * 根据A_id值与B_id值得到当前follow
     * @param A_id,B_id
     * @return
     */
    public static Follow getFollow(long A_id, long B_id) {
        OrmPredicates ormPredicates = ormcontext.where(Follow.class) ;
        //添加过滤条件
        ormPredicates.equalTo("A_id" , A_id) ;
        ormPredicates.equalTo("B_id" , B_id) ;
        //调用query方法完成登录功能
        List<Follow> follows = ormcontext.query(ormPredicates) ;
        if(follows == null || follows.size() == 0){
            return  null ;
        }
        return follows.get(0) ;
    }

    /**
     * 根据A_id值与B_id值判断是否存在follow
     * @param A_id
     * @param B_id
     * @return
     */
    public static boolean find_follow(long A_id, long B_id){
        OrmPredicates ormPredicates = ormcontext.where(Follow.class) ;
        //添加过滤条件
        ormPredicates.equalTo("A_id" , A_id) ;
        ormPredicates.equalTo("B_id" , B_id) ;
        List<Follow> lists=ormcontext.query(ormPredicates);
        return lists.size() != 0;
    }


    /**
     * 添加 subscribe
     * @param subscribe
     * @return
     */
    public static boolean addSubscribe(Subscribe subscribe){
        OrmPredicates ormPredicates = ormcontext.where(Subscribe.class) ;
        ormPredicates.equalTo("user_id" , subscribe.getUser_id()) ;
        ormPredicates.equalTo("forum_id" , subscribe.getForum_id()) ;
        List<Subscribe> lists=ormcontext.query(ormPredicates);
        if(lists.size() == 0){
            ormcontext.insert(subscribe) ;
            return  ormcontext.flush() ;
        }
        else{
            return false;
        }


    }

    /**
     * 删除 user订阅 forum 的 subscribe 数据
     * @param user_id
     * @param forum_id
     * @return
     */
    public static List<Subscribe> deleteSubscribe(long user_id,long forum_id){
        OrmPredicates ormpredicates = ormcontext.where(Subscribe.class);
        ormpredicates.equalTo("user_id",user_id);
        ormpredicates.equalTo("forum_id",forum_id);
        ormcontext.delete(ormpredicates);
        ormcontext.flush();
        return ormcontext.query(ormpredicates);
    }



    /**
     * 得到所有 subscribe
     * @return
     */
    public static List<Subscribe> getSubscribes() {
        OrmPredicates ormPredicates = ormcontext.where(Subscribe.class) ;
        return ormcontext.query(ormPredicates) ;
    }

    /**
     * 根据user_id值与forum_id值判断是否存在subscribe
     * @param user_id
     * @param forum_id
     * @return
     */
    public static boolean find_subscribe(long user_id,long forum_id){
        OrmPredicates ormPredicates = ormcontext.where(Subscribe.class) ;
        //添加过滤条件
        ormPredicates.equalTo("user_id" , user_id) ;
        ormPredicates.equalTo("forum_id" , forum_id) ;
        List<Subscribe> lists=ormcontext.query(ormPredicates);
        return lists.size() != 0;
    }



    /**
     * 根据ID值得到当前用户对象
     * @param id
     * @return
     */
    public static Tuser getTuser(long id) {
        OrmPredicates ormPredicates = ormcontext.where(Tuser.class) ;
        //添加过滤条件
        ormPredicates.equalTo("uid" , id) ;
        List<Tuser> tusers = ormcontext.query(ormPredicates) ;
        if(tusers == null || tusers.size() == 0){
            return  null ;
        }
        return tusers.get(0) ;
    }

    /**
     * 根据uname值得到当前用户对象
     * @param uname
     * @return
     */
    public static Tuser getTuser(String uname) {
        OrmPredicates ormPredicates = ormcontext.where(Tuser.class) ;
        //添加过滤条件
        ormPredicates.equalTo("uname" , uname) ;
        List<Tuser> tusers = ormcontext.query(ormPredicates) ;
        if(tusers == null || tusers.size() == 0){
            return  null ;
        }
        return tusers.get(0) ;
    }

    public static void update_Tuser(long id , String UserName , String NickName){
        OrmPredicates ormPredicates = ormcontext.where(Tuser.class) ;
        //添加过滤条件
        ormPredicates.equalTo("uid" , id) ;
        List<Tuser> tusers = ormcontext.query(ormPredicates) ;

        tusers.get(0).setUser_NickName(NickName);
        tusers.get(0).setUname(UserName);
        ormcontext.update(tusers.get(0));
        ormcontext.flush();
    }


    public static void update_Tuser(long id , String pwd){
        OrmPredicates ormPredicates = ormcontext.where(Tuser.class) ;
        //添加过滤条件
        ormPredicates.equalTo("uid" , id) ;
        List<Tuser> tusers = ormcontext.query(ormPredicates) ;

        tusers.get(0).setPwd(pwd);
        ormcontext.update(tusers.get(0));
        ormcontext.flush();
    }



    /**
     * 登录信息
     * @param tuser
     * @return
     */
    public static Tuser login(Tuser tuser){
        //需要先得到API对象
        OrmPredicates ormpredicates = ormcontext.where(Tuser.class);
        ormpredicates.equalTo("uname", tuser.getUname());
        ormpredicates.equalTo("pwd",tuser.getPwd());

        List<Tuser> tusers = ormcontext.query(ormpredicates);
        if(tusers == null || tusers.size()==0){
            return null;
        }
        return tusers.get(0) ;
    }

    /**
     * 添加用户信息
     * @param tuser
     * @return
     */
    public static boolean addTuser(Tuser tuser){
        ormcontext.insert(tuser);
        return ormcontext.flush();
    }






    /**
     * 添加 forum
     * @param forum
     * @return
     */
    public static boolean addForum(Forum forum){
        ormcontext.insert(forum) ;
        return  ormcontext.flush() ;
    }

    /**
     * 得到所有forum
     * @return
     */
    public static List<Forum> getForums() {
        OrmPredicates ormPredicates = ormcontext.where(Forum.class) ;
        return ormcontext.query(ormPredicates) ;
    }

    /**
     * 根据ID值得到当前forum
     * @param id
     * @return
     */
    public static Forum getForum(long id) {
        OrmPredicates ormPredicates = ormcontext.where(Forum.class) ;
        //添加过滤条件
        ormPredicates.equalTo("forum_id" , id) ;
        //调用query方法完成登录功能
        List<Forum> forums = ormcontext.query(ormPredicates) ;
        if(forums == null || forums.size() == 0){
            return  null ;
        }
        return forums.get(0) ;
    }

    /**
     * 根据name值得到当前forum
     * @param name
     * @return
     */
    public static Forum getForum(String name) {
        OrmPredicates ormpredicates = ormcontext.where(Forum.class) ;
        ormpredicates.equalTo("forum_name",name);
        List<Forum> forums = ormcontext.query(ormpredicates) ;
        if(forums == null || forums.size() == 0){
            return  null ;
        }
        return forums.get(0) ;
    }



    /**
     * 添加 comment
     * @param comment
     * @return
     */
    public static boolean addComment(Comment comment){
        ormcontext.insert(comment) ;
        return  ormcontext.flush() ;
    }

    /**
     * 得到所有comment
     * @return
     */
    public static List<Comment> getComments() {
        OrmPredicates ormPredicates = ormcontext.where(Comment.class) ;
        return ormcontext.query(ormPredicates) ;
    }

    /**
     * 根据ID值得到当前评论
     * @param id
     * @return
     */
    public static Comment getComment(long id) {
        OrmPredicates ormPredicates = ormcontext.where(Comment.class) ;
        //添加过滤条件
        ormPredicates.equalTo("comment_id" , id) ;
        //调用query方法完成登录功能
        List<Comment> comments = ormcontext.query(ormPredicates) ;
        if(comments == null || comments.size() == 0){
            return  null ;
        }
        return comments.get(0) ;
    }




    /**
     * 获取到prefrences对应key的value值
     * @param key
     * @return
     */
    public static String getValue(String key) {
        return preferences.getString(key, "");
    }


    /**
     * 将需要使用到的值进行prefrences存储
     * @param user
     * @param tuid
     */
    public static void setValue(String user, Integer tuid) {
        preferences.putString(user, tuid+"");
        preferences.flush(); //保存数据
    }


}
