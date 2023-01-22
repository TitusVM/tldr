
package ch.hearc.jee.tldr.seed;

public enum SeederTLDRData
	{

TLDR1("Article 1 Summary", "This article discusses the impact of technology on society and how it is shaping the future. The author argues that while technology has brought many benefits, it also poses certain challenges that need to be addressed."), //
TLDR2("Article 2 Summary", "This article examines the state of the global economy and the potential for a recession in the near future. The author suggests that policymakers need to take proactive measures to mitigate the risks and ensure economic stability."), //
TLDR3("Article 3 Summary",
		"The article explores the current state of renewable energy and the potential for it to become the primary source of power in the future. The author argues that with the right policies in place, renewable energy can play a significant role in addressing the global climate crisis."), //
TLDR4("Article 4 Summary", "The article provides an overview of the current state of artificial intelligence and its potential impact on various industries. The author discusses the benefits and challenges of AI and suggests ways to ensure that it is developed and used ethically."), //
TLDR5("Article 5 Summary",
		"This article examines the current state of cybersecurity and the potential risks posed by the increasing reliance on technology. The author argues that cybersecurity needs to be a top priority for organizations and governments to protect sensitive information and prevent cyber attacks."), //
TLDR6("Article 6 Summary", "The article discusses the current state of the healthcare system and the potential for technology to improve it. The author suggests that telemedicine, electronic health records, and other digital tools can make healthcare more accessible, efficient, and effective."), //
TLDR7("Article 7 Summary", "This article examines the current state of the education system and the potential for technology to improve it. The author suggests that online and blended learning can make education more accessible, efficient, and effective."), //
TLDR8("Article 8 Summary", "The article discusses the current state of the transportation sector and the potential for technology to improve it. The author suggests that autonomous vehicles, ride-sharing, and other digital tools can make transportation more accessible, efficient, and safe."), //
TLDR9("Article 9 Summary", "This article examines the current state of the retail industry and the potential for technology to improve it. The author suggests that e-commerce, mobile payments, and other digital tools can make retail more accessible, efficient, and convenient."), //
TLDR10("Article 10 Summary", "The article discusses the current state of the energy sector and the potential for technology to improve it. The author suggests that smart grids, renewable energy, and other digital tools can make energy more accessible, efficient, and sustainable."), //
TLDR11("Article 11 Summary", "This article examines the current state of the financial sector and the potential for technology to improve it. The author suggests that online banking, mobile payments, and other digital tools can make finance more accessible, efficient, and secure."), //
TLDR12("Article 12 Summary", "The article discusses the current state of the agriculture industry and the potential for technology to improve it. The author suggests that precision agriculture, data analytics, and other digital tools can make farming more accessible, efficient, and sustainable."), //
TLDR13("Article 13 Summary", "This article examines the current state of the manufacturing industry and the potential for technology to improve it. The author suggests that automation, 3D printing, and other digital tools can make manufacturing more accessible, efficient, and sustainable."), //
TLDR14("Article 14 Summary",
		"The article discusses the current state of the construction industry and the potential for technology to improve it. The author suggests that building information modeling, drones, and other digital tools can make construction more accessible, efficient, and sustainable."), //
TLDR15("Article 15 Summary", "This article examines the current state of the entertainment industry and the potential for technology to improve it. The author suggests that streaming, virtual reality, and other digital tools can make entertainment more accessible, efficient, and immersive."), //
TLDR16("Article 16 Summary", "The article discusses the current state of the media industry and the potential for technology to improve it. The author suggests that online news, podcasts, and other digital tools can make media more accessible, efficient, and interactive."), //
TLDR17("Article 17 Summary", "This article examines the current state of the travel industry and the potential for technology to improve it. The author suggests that online booking, mobile apps, and other digital tools can make travel more accessible, efficient, and personalized."), //
TLDR18("Article 18 Summary", "The article discusses the current state of the sports industry and the potential for technology to improve it. The author suggests that live streaming, virtual reality, and other digital tools can make sports more accessible, efficient, and immersive."), //
TLDR19("Article 19 Summary",
		"This article examines the current state of the environmental industry and the potential for technology to improve it. The author suggests that sensor networks, data analytics, and other digital tools can make environmental monitoring more accessible, efficient, and accurate."), //
TLDR20("Article 20 Summary", "The article discusses the current state of the government industry and the potential for technology to improve it. The author suggests that e-government, digital identity, and other digital tools can make government services more accessible, efficient, and secure.");

	private String name;
	private String content;

	SeederTLDRData(String name, String content)
		{
		this.name = name;
		this.content = content;
		}

	public String getName()
		{
		return name;
		}

	public String getContent()
		{
		return content;
		}

	}
