### SpringBoot整合MongoDB实现文件上传下载

1.[MongoDB官网下载对应版本](https://www.mongodb.com/download-center/community?jmp=nav)

2.安装MongoDB，安装时需注意Install MongoDB Compass默认是勾选的，去掉勾选，否则一直无法安装完成；  
[MongoDB可视化管理工具下载](https://robomongo.org/download)

3.引入依赖  
```maven
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```

4.yml文件配置： spring.data.mongodb.uri=mongodb://127.0.0.1:27017/platform

5.实体类  
```Java
@Document 
public class FileEntity {

	@Id
	private String id;// 类型为String，MongoDB自动分配id
	private String name;// 文件名
	private Binary content;// 文件内容
	private String type; // 文件类型
	private long size; // 文件大小
	private Date createTime;// 上传时间
	    
	//set get省略...
}
```

6.Controller层请求演示代码：文件上传、查看、下载  
```Java
@RequestMapping("mongo") 
@RestController 
public class MongoDBController {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@PostMapping("upload")
	public Object upload(MultipartFile image) throws Exception {
		logger.info(image.getOriginalFilename());
	
		FileEntity fe = new FileEntity();
		fe.setName(image.getOriginalFilename());
		fe.setContent(new Binary(image.getBytes()));
		fe.setType(image.getContentType());
		fe.setSize(image.getSize());
		fe.setCreateTime(new Date());
		fe = mongoTemplate.save(fe);
	
		String url = "http://127.0.0.1:9901/mongo/file/" + fe.getId();
		logger.info(url);
	
		return url;
	}
	
	@GetMapping(value = "file/{id}", produces = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE })
	public Object getImage(@PathVariable String id) {
		logger.info(id);
		FileEntity fe = mongoTemplate.findById(id, FileEntity.class);
		return fe.getContent().getData();
	}
	
	@GetMapping("download/{id}")
	public void download(@PathVariable String id, HttpServletResponse response) throws Exception {
		logger.info(id);
	
		FileEntity fe = mongoTemplate.findById(id, FileEntity.class);
	
		response.setContentType(fe.getType());
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fe.getName(), "UTF-8"));
	
		OutputStream out = response.getOutputStream();
		out.write(fe.getContent().getData());
		out.flush();
		out.close();
	}
}
```

### 其他
1.设计模式demo  
* 创建型模式
	* 创建者模式：com.zy.cloud.mc.designpatterns.builder
	* 工厂模式：com.zy.cloud.mc.designpatterns.factory
		* 简单工厂模式
		* 工厂方法模式
		* 抽象工厂模式
	* 原型模式：com.zy.cloud.mc.designpatterns.prototype
	* 单例模式：com.zy.cloud.mc.designpatterns.singleton
* 结构型模式
	* 适配器模式：com.zy.cloud.mc.designpatterns.adapter
		* 对象的适配器模式
		* 类的适配器模式
	* 桥接模式：com.zy.cloud.mc.designpatterns.bridge
	* 组合模式：com.zy.cloud.mc.designpatterns.composite
	* 装饰者模式：com.zy.cloud.mc.designpatterns.decorator
	* 外观模式：com.zy.cloud.mc.designpatterns.facade
	* 享元模式：com.zy.cloud.mc.designpatterns.flyweight
	* 代理模式：com.zy.cloud.mc.designpatterns.proxy
		* 静态代理模式
		* JDK动态代理
		* cglib动态代理
* 行为型模式
	* 责任链模式：com.zy.cloud.mc.designpatterns.chain
	* 命令模式：com.zy.cloud.mc.designpatterns.command
	* 解释器模式：com.zy.cloud.mc.designpatterns.interpreter
	* 迭代器模式：com.zy.cloud.mc.designpatterns.iterator
	* 中介者模式：com.zy.cloud.mc.designpatterns.mediator
	* 备忘录模式：com.zy.cloud.mc.designpatterns.memento
	* 观察者模式：com.zy.cloud.mc.designpatterns.observer
	* 状态模式：com.zy.cloud.mc.designpatterns.state
	* 策略模式：com.zy.cloud.mc.designpatterns.strategy
	* 模板模式：com.zy.cloud.mc.designpatterns.template
	* 观察者模式：com.zy.cloud.mc.designpatterns.visitor

2.通过redis实现session共享，redis消息订阅发布简单配置

3.实体参数注解方式验证

4.集成阿里巴巴Sentinel限流  
* 主要步骤
	* 1).[下载可视化管理界面jar](https://github.com/alibaba/Sentinel/releases)，通过命令启动java -jar xxx.jar
	* 2).访问127.0.0.1:8080，默认账号、密码均为sentinel
	* 3).引入依赖  
		```maven
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
			<version>0.2.2.RELEASE</version>
		</dependency>
		```
	* 4).yml配置:spring.cloud.sentinel.transport.dashboard=127.0.0.1:8080
	
5.git clone速度慢解决办法，追加--depth=1，例如：git clone https://github.com/291435070/SpringBoot2MongoDB.git --depth=1

6.git更新代码出现错误：fatal: unable to auto-detect email address，解决办法是进入项目目录的.git文件夹，在config文件末尾追加（注：email、name随便写）
	[user]
		email=291435070@qq.com
		name=James

