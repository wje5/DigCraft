package com.huajiliming.digcraft.inventory;

import java.util.Arrays;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.huajiliming.digcraft.network.MessageBookPage;
import com.huajiliming.digcraft.network.NetworkHandler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

//A lot of code copy from vanilla
public class GuiScreenStandardBook extends GuiScreen {
	private GuiButton buttonDone;
	private int bookImageWidth = 192;
	private int bookImageHeight = 192;
	private NextPageButton buttonNextPage;
	private NextPageButton buttonPreviousPage;
	private int currPage;
	private int bookTotalPages;
	private String text;
	private List<String> pages;
	private static final ResourceLocation bookGuiTextures = new ResourceLocation("textures/gui/book.png");
	private ItemStack stack;

	public GuiScreenStandardBook(ItemStack stack, String name) {
		this.text = I18n.format(name, new Object[0]);
//		int maxLengthPerPage = 312;
//		if (Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode() == "zh_CN") {
//			maxLengthPerPage = 156;
//		}
		this.text = this.text.replace('@', '\n');
//		for (int i = 0;; i++) {
//			this.bookTotalPages++;
//			if (this.text.length() > maxLengthPerPage) {
//				this.pages.add(this.text.substring(0,
//						this.text.length() < maxLengthPerPage ? this.text.length() : maxLengthPerPage));
//				this.text = this.text.substring(maxLengthPerPage);
//			} else {
//				this.pages.add(this.text);
//				break;
//			}
//		}
		this.pages = Arrays.asList(this.text.split("ø"));
		this.bookTotalPages = this.pages.size();
		NBTTagCompound tag = stack.getTagCompound();
		if (tag == null) {
			tag = new NBTTagCompound();
		}
		this.currPage = tag.getInteger("page");
		if (this.currPage >= this.bookTotalPages) {
			this.currPage = this.bookTotalPages - 1;
		}
		stack.setTagCompound(tag);
		this.stack = stack;
	}

	@Override
	public void initGui() {
		this.buttonList.clear();
		Keyboard.enableRepeatEvents(true);
		this.buttonList.add(this.buttonDone = new GuiButton(0, this.width / 2 - 100, 4 + this.bookImageHeight, 200, 20,
				I18n.format("gui.done", new Object[0])));
		int i = (this.width - this.bookImageWidth) / 2;
		byte b0 = 2;
		this.buttonList.add(this.buttonNextPage = new NextPageButton(1, i + 120, b0 + 154, true));
		this.buttonList.add(this.buttonPreviousPage = new NextPageButton(2, i + 38, b0 + 154, false));
		this.updateButtons();
		super.initGui();
	}

	private void updateButtons() {
		this.buttonNextPage.visible = true;
		this.buttonPreviousPage.visible = true;
		this.buttonDone.visible = true;
	}

	@Override
	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
	}

	@Override
	protected void actionPerformed(GuiButton parButton) {
		if (parButton == this.buttonDone) {
			this.mc.displayGuiScreen((GuiScreen) null);
		} else if (parButton == this.buttonNextPage) {
			if (this.currPage < bookTotalPages - 1) {
				this.currPage++;
			} else {
				this.currPage = 0;
			}
		} else if (parButton == this.buttonPreviousPage) {
			if (this.currPage > 0) {
				this.currPage--;
			} else {
				this.currPage = this.bookTotalPages - 1;
			}
		}
		NetworkHandler.instance.sendToServer(new MessageBookPage(this.currPage));
	}

	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(bookGuiTextures);
		int k = (this.width - this.bookImageWidth) / 2;
		byte b0 = 2;
		this.drawTexturedModalRect(k, b0, 0, 0, this.bookImageWidth, this.bookImageHeight);
		String s = I18n.format("book.pageIndicator",
				new Object[] { Integer.valueOf(this.currPage + 1), Integer.valueOf(this.bookTotalPages) });
		String s1 = pages.get(this.currPage);
//
//		if (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages.tagCount()) {
//			s1 = this.bookPages.getStringTagAt(this.currPage);
//		}
//
		int l = this.fontRendererObj.getStringWidth(s);
		this.fontRendererObj.drawString(s, k - l + this.bookImageWidth - 44, b0 + 16, 0);
		this.fontRendererObj.drawSplitString(s1, k + 36, b0 + 16 + 16, 116, 0);

		super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
	}

	@SideOnly(Side.CLIENT)
	private static class NextPageButton extends GuiButton {
		private final boolean field_146151_o;
		private static final String __OBFID = "CL_00000745";

		public NextPageButton(int p_i1079_1_, int p_i1079_2_, int p_i1079_3_, boolean p_i1079_4_) {
			super(p_i1079_1_, p_i1079_2_, p_i1079_3_, 23, 13, "");
			this.field_146151_o = p_i1079_4_;
		}

		@Override
		public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_) {
			if (this.visible) {
				boolean flag = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition
						&& p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				p_146112_1_.getTextureManager().bindTexture(bookGuiTextures);
				int k = 0;
				int l = 192;

				if (flag) {
					k += 23;
				}

				if (!this.field_146151_o) {
					l += 13;
				}

				this.drawTexturedModalRect(this.xPosition, this.yPosition, k, l, 23, 13);
			}
		}
	}
}
