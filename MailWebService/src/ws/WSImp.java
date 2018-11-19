package ws;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * WebService实现类
 * 
 * @author Johness
 * 
 */
@WebService(endpointInterface = "ws.WS")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class WSImp implements WS {

	@Override
	public int CheckTime(Date clientTime) {
		// 精确到秒
		String dateServer = new java.sql.Date(System.currentTimeMillis()).toString() + " "
				+ new java.sql.Time(System.currentTimeMillis());
		String dateClient = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(clientTime);
		return dateServer.equals(dateClient) ? 1 : 0;
	}

	@Override
	public boolean sendEmail(String url, String body) {
		// TODO Auto-generated method stub
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIQqvnfwmJdMKX",
				"gXDgeiqTkyTimMco30TygotKJns9jo");
		IAcsClient client = new DefaultAcsClient(profile);
		SingleSendMailRequest request = new SingleSendMailRequest();
		{
			try {
				request.setAccountName("mail.liji@liji.live");
				request.setFromAlias("LiJi");
				request.setAddressType(1);
				request.setTagName("控制台创建的标签");
				request.setReplyToAddress(true);
				request.setToAddress(url);
				// 可以给多个收件人发送邮件，收件人之间用逗号分开，批量发信建议使用BatchSendMailRequest方式
				// request.setToAddress("邮箱1,邮箱2");
				request.setSubject("Message");
				request.setHtmlBody(body);
				SingleSendMailResponse httpResponse = client.getAcsResponse(request);
			} catch (ServerException e) {
				e.printStackTrace();
			} catch (ClientException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean sendEmailBatch(String[] url, String body) {
		// TODO Auto-generated method stub
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIQqvnfwmJdMKX",
				"gXDgeiqTkyTimMco30TygotKJns9jo");
		IAcsClient client = new DefaultAcsClient(profile);
		SingleSendMailRequest request = new SingleSendMailRequest();
		{
			try {
				request.setAccountName("mail.liji@liji.live");
				request.setFromAlias("LiJi");
				request.setAddressType(1);
				request.setTagName("控制台创建的标签");
				request.setReplyToAddress(true);
				int n = url.length;
				String urls = "";
				String a = null;
				for (int i = 0; i <n; i++) {
					if (i != n-1) {
						url[i]+=",";
					}
			    urls+=url[i];
				}
				
				request.setToAddress(urls);
				// 可以给多个收件人发送邮件，收件人之间用逗号分开，批量发信建议使用BatchSendMailRequest方式
				// request.setToAddress("邮箱1,邮箱2");
				request.setSubject("");
				request.setHtmlBody(body);
				SingleSendMailResponse httpResponse = client.getAcsResponse(request);
			} catch (ServerException e) {
				e.printStackTrace();
			} catch (ClientException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean validateEmailAddress(String url) {
		// TODO Auto-generated method stub
		String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
		// 正则表达式的模式 编译正则表达式
		Pattern p = Pattern.compile(RULE_EMAIL);
		// 正则表达式的匹配器
		Matcher m = p.matcher(url);
		// 进行正则匹配\
		return m.matches();

	}
}