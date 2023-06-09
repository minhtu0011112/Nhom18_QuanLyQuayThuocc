USE [master]
GO
/****** Object:  Database [QuanLyQuayThuoc2] ******/
CREATE DATABASE [QuanLyQuayThuoc2]
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyQuayThuoc2].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET RECOVERY FULL 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'QuanLyQuayThuoc2', N'ON'
GO
USE [QuanLyQuayThuoc2]
GO
/****** Object:  UserDefinedFunction [dbo].[inMaThuoc_GiaBan]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
------------------------------------------------------------------
--Xuat gia ban cua 1 thuoc
create function [dbo].[inMaThuoc_GiaBan](@MaThuoc char(8))
returns money
as
begin
	declare @GiaBan money
	set @GiaBan=(select Thuoc.GiaBan from Thuoc where Thuoc.MaThuoc=@MaThuoc)
	return @GiaBan
end


GO
/****** Object:  UserDefinedFunction [dbo].[TuDongTangMaNV]   ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
------------------------------------------------------------------
-- Tự động tăng ma NhanVien
create function [dbo].[TuDongTangMaNV]()
returns char(8)
as
	begin
	declare @MaNV char(5)
	declare @SoNhanVien int
	set @SoNhanVien = (select count(NhanVien.MaNV) from NhanVien)
	if (@SoNhanVien=0)
		set @MaNV='NV111'
	else 
		begin
			set @MaNV = RIGHT((select max(NhanVien.MaNV) from NhanVien),3)
			set @SoNhanVien = CAST(@MaNV as int)+1
			set @MaNV = 'NV' + CAST(@SoNhanVien as char(3))
		end
	return @MaNV
	end


GO
/****** Object:  UserDefinedFunction [dbo].[TuDongTangMaThuoc]   ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
------------------------------------------------------------------
-- Tự động tăng ma thuoc
create function [dbo].[TuDongTangMaThuoc]()
returns char(8)
as
	begin
		declare @SoThuoc int
		declare @MaThuoc char(8)
		set @SoThuoc=(select count(Thuoc.MaThuoc)from Thuoc)
		if (@SoThuoc=0)
			begin
				set @MaThuoc='T111'
			end
		else
			begin
				set @MaThuoc= RIGHT((select Max(Thuoc.MaThuoc) from Thuoc),3)
				set @SoThuoc=cast(@MaThuoc as int)+1
				set @MaThuoc='T'+CAST(@SoThuoc as char(3))
			end
		return @MaThuoc
	end


GO
/****** Object:  UserDefinedFunction [dbo].[TuDongTangMaTK]   ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
------------------------------------------------------------------
-- Tự động tăng ma TaiKhoan
create function [dbo].[TuDongTangMaTK]()
returns char(8)
as
	begin
	declare @MaTK char(8)
	declare @SoTaiKhoan int
	set @SoTaiKhoan = (select count(TaiKhoan.MaTK) from TaiKhoan)
	if (@SoTaiKhoan=0)
		set @MaTK='TK111'
	else 
		begin
			set @MaTK = RIGHT((select max(TaiKhoan.MaTK) from TaiKhoan),3)
			set @SoTaiKhoan = CAST(@MaTK as int)+1
			set @MaTK = 'TK' + CAST(@SoTaiKhoan as char(3))
		end
	return @MaTK
	end


GO
/****** Object:  Table [dbo].[CTHoaDon]    PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CTHoaDon](
	[MaHD] [char](8) NOT NULL,
	[MaThuoc] [char](8) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[HinhThucBan] [nvarchar](10) NULL,
	[TongCong] [float] NULL,
	[ChietKhau] [int] NULL,
	[KhachDua] [float] NULL,
	[TraKhach] [float] NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC,
	[MaThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DonVi]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DonVi](
	[MaDV] [char](8) NOT NULL,
	[TenDonVi] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HoaDon]  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [char](8) NOT NULL,
	[MaNV] [char](8) NULL,
	[MaKH] [char](8) NULL,
	[NgayLapHD] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO



SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KhachHang]   ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [char](8) NOT NULL,
	[MaLoaiKH] [char](8) NULL,
	[TenKH] [nvarchar](50) NULL,
	[GioiTinh] [nvarchar](5) NULL,
	[NgaySinh] [date] NULL,
	[CMND] [nvarchar](10) NULL,
	[DiaChi] [nvarchar](60) NULL,
	[TinhTP] [nvarchar](50) NULL,
	[QuanHuyen] [nvarchar](50) NULL,
	[SDT] [nchar](10) NULL,
	[GhiChu] [nvarchar](150) NULL,
 CONSTRAINT [PK__KhachHan__2725CF1E5C33E7BB] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LoaiKH]    *****/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LoaiKH](
	[MaLoaiKH] [char](8) NOT NULL,
	[TenLoaiKH] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLoaiKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LoaiThuoc]     ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LoaiThuoc](
	[MaLoaiT] [char](8) NOT NULL,
	[TenLoaiThuoc] [nvarchar](60) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLoaiT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhanVien]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [char](8) NOT NULL,
	[HoTenNV] [nvarchar](100) NULL,
	[ChucVu] [nvarchar](50) NULL,
	[GioiTinh] [nvarchar](5) NULL,
	[NgaySinh] [date] NULL,
	[NgayVaoLam] [date] NULL,
	[CMND] [nvarchar](10) NULL,
	[DiaChi] [nvarchar](60) NULL,
	[QuanHuyen] [nvarchar](50) NULL,
	[TinhTP] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[SDT] [nvarchar](15) NULL,
	[TinhTrang] [smallint] NULL,
 CONSTRAINT [PK__NhanVien__2725D70AF862A4BB] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhaSanXuat]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhaSanXuat](
	[MaNSX] [char](8) NOT NULL,
	[TenNSX] [nvarchar](60) NULL,
	[SDT] [nvarchar](15) NULL,
	[Fax] [nvarchar](10) NULL,
	[Email] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNSX] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[QuocGia]   ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[QuocGia](
	[MaQG] [char](8) NOT NULL,
	[TenQuocGia] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaQG] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TaiKhoan]     ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[TenTK] [char](8) NOT NULL,
	[MatKhau] [nvarchar](20) NOT NULL,
	[QuanLi] [int] NULL,
 CONSTRAINT [PK__TaiKhoan__27250070333BE9B5] PRIMARY KEY CLUSTERED 
(
	[TenTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Thuoc]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Thuoc](
	[MaThuoc] [char](8) NOT NULL,
	[TenThuoc] [nvarchar](50) NULL,
	[GiaBan] [float] NOT NULL,
	[SoLuong] [int] NULL,
	[MoTa] [nvarchar](150) NULL,
	[MaNSX] [char](8) NULL,
	[MaLoaiT] [char](8) NULL,
	[MaDV] [char](8) NULL,
	[MaQG] [char](8) NULL,
 CONSTRAINT [PK__Thuoc__4BB1F620E86ED66F] PRIMARY KEY CLUSTERED 
(
	[MaThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  UserDefinedFunction [dbo].[ThongKeDoanhThuTheoNgay]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
------------------------------------------------------------------
--ThongkeDoanhThuTheoNgay
create function [dbo].[ThongKeDoanhThuTheoNgay](@start date, @end date)
returns table
as
return(
		select HoaDon.NgayLapHD,TongSoHoaDon= count(HoaDon.MaHD),
		TongTienBanThuoc=sum(Thuoc.GiaBan*CTHoaDon.SoLuong)
		from HoaDon join CTHoaDon on HoaDon.MaHD=CTHoaDon.MaHD
					join Thuoc on Thuoc.Mathuoc=CTHoaDon.Mathuoc
		where HoaDon.NgayLapHD is not null and(HoaDon.NgayLapHD>=@start and HoaDon.NgayLapHD<=@end)
		group by HoaDon.NgayLapHD
		)


GO
/****** Object:  UserDefinedFunction [dbo].[ThongKeDoanhThuTheoThang] ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
------------------------------------------------------------------
--ThongkeDoanhThuTheoThang
create function [dbo].[ThongKeDoanhThuTheoThang](@nam int)
returns table
as
return(
		select MONTH(HoaDon.NgayLapHD) as Thang,TongSoHoaDon= count(HoaDon.MaHD),
		TongTienChoThue=sum(Thuoc.GiaBan*CTHoaDon.SoLuong)
		from HoaDon join CTHoaDon on HoaDon.MaHD=CTHoaDon.MaHD
					join Thuoc on Thuoc.MaThuoc=CTHoaDon.MaThuoc
		where HoaDon.NgayLapHD is not null and YEAR(HoaDon.NgayLapHD)=@nam
		group by MONTH(HoaDon.NgayLapHD)
		)


GO
/****** Object:  UserDefinedFunction [dbo].[ThongKeTop10ThuocMuaNhieuNhat]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
------------------------------------------------------------------
--Thong ke top 10 thuoc mua nhieu nhat tu ngay... den ngay...
create function [dbo].[ThongKeTop10ThuocMuaNhieuNhat](@start date,@end date)
returns table
as
	return(
			select TOP 10 Thuoc.MaThuoc, Thuoc.TenThuoc,NhaSanXuat.TenNSX,LoaiThuoc.TenLoaiThuoc,
			SoLuongMua=sum(CTHoaDon.SoLuong)
			from Thuoc join NhaSanXuat on Thuoc.MaNSX=NhaSanXuat.MaNSX
						 join LoaiThuoc on LoaiThuoc.MaLoaiT=Thuoc.MaLoaiT
						 join CTHoaDon on CTHoaDon.MaThuoc=Thuoc.MaThuoc
						 join HoaDon on CTHoaDon.MaHD=HoaDon.MaHD
			where HoaDon.NgayLapHD>=@start and HoaDon.NgayLapHD<=@end
			group by Thuoc.MaThuoc,Thuoc.TenThuoc,LoaiThuoc.TenLoaiThuoc,NhaSanXuat.TenNSX
			order by sum(CTHoaDon.SoLuong) DESC
			)


GO
INSERT [dbo].[CTHoaDon] ([MaHD], [MaThuoc], [SoLuong], [HinhThucBan], [TongCong], [ChietKhau], [KhachDua], [TraKhach], [TrangThai]) VALUES (N'HD111   ', N'T111    ', 5, N'Lẻ', 250000, 0, 500000, 130000, 0)
INSERT [dbo].[CTHoaDon] ([MaHD], [MaThuoc], [SoLuong], [HinhThucBan], [TongCong], [ChietKhau], [KhachDua], [TraKhach], [TrangThai]) VALUES (N'HD111   ', N'T112    ', 2, N'Lẻ', 120000, 0, 500000, 130000, 0)
INSERT [dbo].[CTHoaDon] ([MaHD], [MaThuoc], [SoLuong], [HinhThucBan], [TongCong], [ChietKhau], [KhachDua], [TraKhach], [TrangThai]) VALUES (N'HD112   ', N'T111    ', 14, N'Lẻ', 790000, 0, 7558585, 6768585, 2)
INSERT [dbo].[CTHoaDon] ([MaHD], [MaThuoc], [SoLuong], [HinhThucBan], [TongCong], [ChietKhau], [KhachDua], [TraKhach], [TrangThai]) VALUES (N'HD113   ', N'T112    ', 2, N'Lẻ', 100000, 0, 232323, 132323, 2)
INSERT [dbo].[CTHoaDon] ([MaHD], [MaThuoc], [SoLuong], [HinhThucBan], [TongCong], [ChietKhau], [KhachDua], [TraKhach], [TrangThai]) VALUES (N'HD114   ', N'T112    ', 1, N'Lẻ', 60000, 0, 777777, 717777, 0)
INSERT [dbo].[CTHoaDon] ([MaHD], [MaThuoc], [SoLuong], [HinhThucBan], [TongCong], [ChietKhau], [KhachDua], [TraKhach], [TrangThai]) VALUES (N'HD115   ', N'T112    ', 1, N'Lẻ', 60000, 0, 777777, 717777, 2)
INSERT [dbo].[CTHoaDon] ([MaHD], [MaThuoc], [SoLuong], [HinhThucBan], [TongCong], [ChietKhau], [KhachDua], [TraKhach], [TrangThai]) VALUES (N'HD116   ', N'T112    ', 1, N'Lẻ', 60000, 0, 130000, 10000, 2)
INSERT [dbo].[CTHoaDon] ([MaHD], [MaThuoc], [SoLuong], [HinhThucBan], [TongCong], [ChietKhau], [KhachDua], [TraKhach], [TrangThai]) VALUES (N'HD117   ', N'T111    ', 1, N'Lẻ', 50000, 0, 120000, 10000, 2)
INSERT [dbo].[CTHoaDon] ([MaHD], [MaThuoc], [SoLuong], [HinhThucBan], [TongCong], [ChietKhau], [KhachDua], [TraKhach], [TrangThai]) VALUES (N'HD117   ', N'T112    ', 1, N'Lẻ', 60000, 0, 120000, 10000, 2)
INSERT [dbo].[DonVi] ([MaDV], [TenDonVi]) VALUES (N'DV111   ', N'Viên')
INSERT [dbo].[DonVi] ([MaDV], [TenDonVi]) VALUES (N'DV222   ', N'Chai')
INSERT [dbo].[DonVi] ([MaDV], [TenDonVi]) VALUES (N'DV333   ', N'Gói')
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [NgayLapHD]) VALUES (N'HD111   ', N'NV111   ', N'KH111   ', CAST(N'2019-10-10' AS Date))
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [NgayLapHD]) VALUES (N'HD112   ', N'NV111   ', N'KH111   ', CAST(N'2019-12-06' AS Date))
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [NgayLapHD]) VALUES (N'HD113   ', N'NV111   ', N'KH113   ', CAST(N'2019-12-06' AS Date))
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [NgayLapHD]) VALUES (N'HD114   ', N'NV111   ', N'KH112   ', CAST(N'2019-12-06' AS Date))
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [NgayLapHD]) VALUES (N'HD115   ', N'NV111   ', N'KH113   ', CAST(N'2019-12-06' AS Date))
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [NgayLapHD]) VALUES (N'HD116   ', N'NV111   ', N'KH118   ', CAST(N'2019-12-08' AS Date))
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [NgayLapHD]) VALUES (N'HD117   ', N'NV111   ', N'KH113   ', CAST(N'2019-12-08' AS Date))
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH111   ', N'LO111   ', N'Trí Tài', N'Nam', CAST(N'2003-10-10' AS Date), N'235879451', N'Hà Nội', N'TinhTP', N'QuanHuyen', N'0125649875', N'anhd@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH112   ', N'LO111   ', N'Mai Lộc', N'Nam', CAST(N'2003-10-10' AS Date), N'122333456', N'Đà Nẵng', N'TinhTP', N'QuanHuyen', N'0123415678', N'thica@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH113   ', N'LO111   ', N'Võ Văn Nghĩa', N'Nam', CAST(N'2003-10-10' AS Date), N'144523456', N'hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0124563985', N'ada@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH114   ', N'LO111   ', N'Nguyễn Canh', N'Nam', CAST(N'1998-10-10' AS Date), N'123412456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0125863498', N'nghiahoo@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH115   ', N'LO111   ', N'Long Cánh', N'Nam', CAST(N'1989-10-10' AS Date), N'123447756', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0125986789', N'canhcanh@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH116   ', N'LO111   ', N'Trần Dần', N'Nam', CAST(N'1989-11-10' AS Date), N'770123456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0968456789', N'trandan@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH117   ', N'LO111   ', N'Trần Dần', N'Nữ', CAST(N'1978-07-10' AS Date), N'575013456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0985656789', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH118   ', N'LO111   ', N'Ông Lê Tân', N'Nam', CAST(N'1984-08-10' AS Date), N'757013456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0936587491', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH119   ', N'LO111   ', N'Nguyễn Kinh', N'Nam', CAST(N'1969-06-10' AS Date), N'870123456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0548154961', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH120   ', N'LO111   ', N'Tinh Tinh', N'Nam', CAST(N'1988-10-08' AS Date), N'808123456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0916432587', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH121   ', N'LO111   ', N'Châu Khải Đức', N'Nam', CAST(N'1989-01-10' AS Date), N'012378456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0125876349', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH122   ', N'LO111   ', N'Linh Tinh', N'Nữ', CAST(N'1998-10-10' AS Date), N'018283456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0122586489', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH123   ', N'LO111   ', N'Tú Cần', N'Nam', CAST(N'1991-10-11' AS Date), N'450123456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0123436985', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH124   ', N'LO111   ', N'Cận Cần', N'Nam', CAST(N'1992-10-19' AS Date), N'550123456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0362589652', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH125   ', N'LO111   ', N'Trần Tim', N'Nam', CAST(N'1992-10-28' AS Date), N'580123456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0365892451', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH126   ', N'LO111   ', N'Cung Sanh', N'Nam', CAST(N'1992-02-23' AS Date), N'488123456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0368519421', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH127   ', N'LO111   ', N'Nguyễn Đức', N'Nam', CAST(N'2000-05-06' AS Date), N'899013456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0365896415', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH128   ', N'LO111   ', N'Trần Chánh', N'Nam', CAST(N'2000-10-06' AS Date), N'998023456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0896534812', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH129   ', N'LO111   ', N'Trần Kim', N'Nam', CAST(N'2000-10-04' AS Date), N'470123456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0258964318', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH130   ', N'LO111   ', N'Trần Thảo Nhi', N'Nữ', CAST(N'2000-11-10' AS Date), N'023844656', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0215487963', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH131   ', N'LO111   ', N'Nguyễn Ngọc Ngọc', N'Nữ', CAST(N'2001-10-13' AS Date), N'012346486', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0896475819', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH132   ', N'LO111   ', N'Lê Thảo Y', N'Nữ', CAST(N'1996-10-10' AS Date), N'123454226', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0896451782', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH133   ', N'LO111   ', N'Nguyễn Kin Yến', N'Nữ', CAST(N'1993-10-10' AS Date), N'012123456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0968563214', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH134   ', N'LO111   ', N'Trần Hữu Tài', N'Nam', CAST(N'1997-10-10' AS Date), N'012345206', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0215896354', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH135   ', N'LO111   ', N'Hà Văn Trụ', N'Nam', CAST(N'1969-10-10' AS Date), N'012345226', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0965863254', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH136   ', N'LO111   ', N'Trần Thảo Vy', N'Nữ', CAST(N'1991-10-24' AS Date), N'012304556', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0236589478', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH137   ', N'LO111   ', N'Nguyễn Yến Nhi', N'Nữ', CAST(N'1998-10-28' AS Date), N'012345506', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'013254698 ', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH138   ', N'LO111   ', N'Oanh Thị Hiền', N'Nữ', CAST(N'1991-10-27' AS Date), N'012345586', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'012694899 ', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH139   ', N'LO111   ', N'Lê Hiền Nhi', N'Nữ', CAST(N'1999-10-26' AS Date), N'015223456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0934615874', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH140   ', N'LO111   ', N'Văn Kim Tú', N'Nữ', CAST(N'1998-10-25' AS Date), N'012403456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0345691844', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH141   ', N'LO111   ', N'Văn Thị Thu Yến', N'Nữ', CAST(N'2003-10-24' AS Date), N'012344156', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0963587124', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH142   ', N'LO111   ', N'Huỳnh Thị Thúy', N'Nữ', CAST(N'2003-10-23' AS Date), N'012341216', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0434648494', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH143   ', N'LO111   ', N'Phạm Lê Ngân', N'Nữ', CAST(N'2003-06-21' AS Date), N'024543456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0346491541', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH144   ', N'LO111   ', N'Nguyễn Trần Dương', N'Nam', CAST(N'1997-12-15' AS Date), N'012454856', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0345484444', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH145   ', N'LO111   ', N'Trần Nam', N'Nam', CAST(N'1997-10-10' AS Date), N'012344876', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0454545454', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH146   ', N'LO111   ', N'Võ Ánh', N'Nữ', CAST(N'1997-10-10' AS Date), N'084523456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0236589641', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH147   ', N'LO111   ', N'Mông Tài', N'Nữ', CAST(N'1997-10-15' AS Date), N'801542456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0101014444', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH148   ', N'LO111   ', N'Mông Lộc', N'Nam', CAST(N'2003-10-01' AS Date), N'084128456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0404546433', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH149   ', N'LO111   ', N'Mông Nghĩa', N'Nữ', CAST(N'2003-09-10' AS Date), N'048823456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0414141414', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH150   ', N'LO111   ', N'Mông Mông', N'Nữ', CAST(N'2003-07-10' AS Date), N'023544456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0050505054', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH151   ', N'LO111   ', N'Kim Ngân', N'Nữ', CAST(N'1999-10-08' AS Date), N'012342486', N'Hà Nội', N'TinhTP', N'QuanHuyen', N'0985552424', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH152   ', N'LO111   ', N'Trần Thị Cúc', N'Nữ', CAST(N'1993-12-10' AS Date), N'012345256', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0999999944', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH153   ', N'LO111   ', N'Võ Tính', N'Nam', CAST(N'1996-06-10' AS Date), N'032123456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0988888888', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH154   ', N'LO111   ', N'Võ Văn Tài', N'Nam', CAST(N'1995-10-06' AS Date), N'012312356', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0124141242', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH155   ', N'LO111   ', N'Trần Sinh', N'Nam', CAST(N'1995-10-12' AS Date), N'240123456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0987563215', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH156   ', N'LO111   ', N'Trương Tú', N'Nam', CAST(N'1989-10-11' AS Date), N'012342456', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0236548961', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH157   ', N'LO111   ', N'Tu Nhi', N'Nữ', CAST(N'2005-12-10' AS Date), N'236589542', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0315151444', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH158   ', N'LO111   ', N'Cơ Yến Linh', N'Nam', CAST(N'1996-11-02' AS Date), N'123412356', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0878888888', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH159   ', N'LO111   ', N'Văn Thiên', N'Nam', CAST(N'1989-10-10' AS Date), N'256985478', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0941414141', N'NO')
INSERT [dbo].[KhachHang] ([MaKH], [MaLoaiKH], [TenKH], [GioiTinh], [NgaySinh], [CMND], [DiaChi], [TinhTP], [QuanHuyen], [SDT], [GhiChu]) VALUES (N'KH160   ', N'LO111   ', N'Kim Sào', N'Nữ', CAST(N'1988-09-10' AS Date), N'325698745', N'Hồ Chí Minh', N'TinhTP', N'QuanHuyen', N'0999998888', N'NO')
INSERT [dbo].[LoaiKH] ([MaLoaiKH], [TenLoaiKH]) VALUES (N'LO111   ', N'sinh vien')
INSERT [dbo].[LoaiThuoc] ([MaLoaiT], [TenLoaiThuoc]) VALUES (N'LT1     ', N'Thuốc không kê đơn')
INSERT [dbo].[LoaiThuoc] ([MaLoaiT], [TenLoaiThuoc]) VALUES (N'LT111   ', N'Thuốc Kê Đơn')
INSERT [dbo].[LoaiThuoc] ([MaLoaiT], [TenLoaiThuoc]) VALUES (N'LT2     ', N'Thực phẩm chức năng')
INSERT [dbo].[LoaiThuoc] ([MaLoaiT], [TenLoaiThuoc]) VALUES (N'LT3     ', N'Mỹ phẩm')
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [ChucVu], [GioiTinh], [NgaySinh], [NgayVaoLam], [CMND], [DiaChi], [QuanHuyen], [TinhTP], [Email], [SDT], [TinhTrang]) VALUES (N'1       ', N'1', N'Nhân Viên', N'Nam', CAST(N'2019-11-04' AS Date), CAST(N'2019-11-30' AS Date), N'235421567', N'100 Nguyễn Thái Sơn', N'Gò Vấp', N'Hồ Chí Minh', N'sdad@yahoo.vn', N'0333254698', 0)
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [ChucVu], [GioiTinh], [NgaySinh], [NgayVaoLam], [CMND], [DiaChi], [QuanHuyen], [TinhTP], [Email], [SDT], [TinhTrang]) VALUES (N'NV111   ', N'Võ Văn Nghĩa', N'Nhân Viên', N'Nam', CAST(N'2001-10-10' AS Date), CAST(N'2010-10-10' AS Date), N'258964784', N'20 Dương Quảng Hàm', N'Gò Vấp', N'Hồ Chí Minh', N'adad@gmail.com', N'0123456789', 1)
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [ChucVu], [GioiTinh], [NgaySinh], [NgayVaoLam], [CMND], [DiaChi], [QuanHuyen], [TinhTP], [Email], [SDT], [TinhTrang]) VALUES (N'NV112   ', N'Trần Công Thịnh', N'Quản Lí', N'Nam', CAST(N'2000-11-02' AS Date), CAST(N'2019-11-21' AS Date), N'215478546', N'Quy Nhơn', N'Quy Nhơn', N'Bình Định', N'sdas@fas.vc', N'0654751235', 1)
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [ChucVu], [GioiTinh], [NgaySinh], [NgayVaoLam], [CMND], [DiaChi], [QuanHuyen], [TinhTP], [Email], [SDT], [TinhTrang]) VALUES (N'NV113   ', N'Nguyễn Văn Từ', N'Nhân Viên', N'Nam', CAST(N'2000-10-12' AS Date), CAST(N'2019-11-13' AS Date), N'421542566', N'42 Trường Sơn', N'Gò Vấp', N'Hồ Chí Minh', N'asdasd@gmail.com', N'0451254786', 0)
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [ChucVu], [GioiTinh], [NgaySinh], [NgayVaoLam], [CMND], [DiaChi], [QuanHuyen], [TinhTP], [Email], [SDT], [TinhTrang]) VALUES (N'NV114   ', N'Nguyễn Lưu Ly', N'Nhân Viên', N'Nam', CAST(N'2001-12-12' AS Date), CAST(N'2018-12-25' AS Date), N'532416854', N'100 Phạm Văn Đồng', N'Gò Vấp', N'Hồ Chí Minh', N'dasd@sad.sad', N'0874561236', 1)
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [ChucVu], [GioiTinh], [NgaySinh], [NgayVaoLam], [CMND], [DiaChi], [QuanHuyen], [TinhTP], [Email], [SDT], [TinhTrang]) VALUES (N'NV115   ', N'Nguyễn Dư', N'Nhân Viên', N'Nam', CAST(N'2000-11-03' AS Date), CAST(N'2019-11-19' AS Date), N'325415698', N'Phước Quang', N'Tuy Phước', N'Bình Định', N'222@fas.com', N'0543215478', 0)
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [ChucVu], [GioiTinh], [NgaySinh], [NgayVaoLam], [CMND], [DiaChi], [QuanHuyen], [TinhTP], [Email], [SDT], [TinhTrang]) VALUES (N'NV116   ', N'Lê Hân', N'Nhân Viên', N'Nữ', CAST(N'2000-12-01' AS Date), CAST(N'2018-12-13' AS Date), N'231234784', N'diachi', N'quanhuyen', N'tinhtp', N'email@gmial.com', N'0346234359', 1)
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [ChucVu], [GioiTinh], [NgaySinh], [NgayVaoLam], [CMND], [DiaChi], [QuanHuyen], [TinhTP], [Email], [SDT], [TinhTrang]) VALUES (N'NV117   ', N'Nguyễn Nam', N'Nhân Viên', N'Nam', CAST(N'2000-12-13' AS Date), CAST(N'2017-12-08' AS Date), N'232123423', N'weqe', N'Quanhuyen', N'qwe', N'trancongthin@asdsad.asd', N'0234123432', 1)
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [ChucVu], [GioiTinh], [NgaySinh], [NgayVaoLam], [CMND], [DiaChi], [QuanHuyen], [TinhTP], [Email], [SDT], [TinhTrang]) VALUES (N'NV118   ', N'Admin Frt', N'Quản Lí', N'Nam', CAST(N'1999-12-03' AS Date), CAST(N'2018-12-13' AS Date), N'234234322', N'Fdfgwdsd', N'3453', N'zxcsdg', N'dgdg@fsdf.com', N'0442312323', 1)
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [ChucVu], [GioiTinh], [NgaySinh], [NgayVaoLam], [CMND], [DiaChi], [QuanHuyen], [TinhTP], [Email], [SDT], [TinhTrang]) VALUES (N'NV119   ', N'Fuu Fsd', N'Nhân Viên', N'Nam', CAST(N'1998-12-10' AS Date), CAST(N'2018-12-06' AS Date), N'231232232', N'Fdssaf', N'quanhuyen', N'ergerg', N'ytu@adsd.com', N'0563453235', 1)
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [ChucVu], [GioiTinh], [NgaySinh], [NgayVaoLam], [CMND], [DiaChi], [QuanHuyen], [TinhTP], [Email], [SDT], [TinhTrang]) VALUES (N'NV222   ', N'Trần Công Thuận', N'Nhân Viên', N'Nữ', CAST(N'1999-05-01' AS Date), CAST(N'2015-05-01' AS Date), N'215482648', N'Phước Quang', N'Tuy Phước', N'Bình Định', N'abc@xyz.mn', N'0335482115', 1)
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [ChucVu], [GioiTinh], [NgaySinh], [NgayVaoLam], [CMND], [DiaChi], [QuanHuyen], [TinhTP], [Email], [SDT], [TinhTrang]) VALUES (N'NV333   ', N'Lê Lê', N'Nhân Viên', N'Nữ', CAST(N'1998-12-18' AS Date), CAST(N'2018-12-20' AS Date), N'295461235', N'654 Lê Quang Định', N'Bình Thạnh', N'Hồ Chí Minh', N'asds@asd.asd', N'0824675193', 1)
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [ChucVu], [GioiTinh], [NgaySinh], [NgayVaoLam], [CMND], [DiaChi], [QuanHuyen], [TinhTP], [Email], [SDT], [TinhTrang]) VALUES (N'NV444   ', N'Lê Nhi', N'Nhân Viên', N'Nam', CAST(N'2001-12-06' AS Date), CAST(N'2017-12-01' AS Date), N'232323232', N'asdasd', N'asdas', N'asdsad', N'asd@assd.asd', N'0333334232', 1)
INSERT [dbo].[NhanVien] ([MaNV], [HoTenNV], [ChucVu], [GioiTinh], [NgaySinh], [NgayVaoLam], [CMND], [DiaChi], [QuanHuyen], [TinhTP], [Email], [SDT], [TinhTrang]) VALUES (N'NV555   ', N'Nguyển Bảy', N'Nhân Viên', N'Nam', CAST(N'2000-01-01' AS Date), CAST(N'2018-12-07' AS Date), N'555555555', N'asdasd', N'555555', N'asd', N'asd@asd.asd', N'0434445678', 1)
INSERT [dbo].[NhaSanXuat] ([MaNSX], [TenNSX], [SDT], [Fax], [Email]) VALUES (N'NSX111  ', N'Traphaco', N'0921910212', N'0236548754', N'thanhtr@gmail.com')
INSERT [dbo].[NhaSanXuat] ([MaNSX], [TenNSX], [SDT], [Fax], [Email]) VALUES (N'NSX112  ', N'Universal', N'0154215426', N'0545658457', N'congthinh@gmail.com')
INSERT [dbo].[NhaSanXuat] ([MaNSX], [TenNSX], [SDT], [Fax], [Email]) VALUES (N'NSX113  ', N'VinaHouse', N'0355555555', N'0545454542', N'sad@asd.as')
INSERT [dbo].[QuocGia] ([MaQG], [TenQuocGia]) VALUES (N'QG111   ', N'Việt Nam')
INSERT [dbo].[QuocGia] ([MaQG], [TenQuocGia]) VALUES (N'QG222   ', N'Lào')
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [QuanLi]) VALUES (N'1       ', N'1', 1)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [QuanLi]) VALUES (N'NV111   ', N'12345', 1)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [QuanLi]) VALUES (N'NV112   ', N'123123', 1)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [QuanLi]) VALUES (N'NV113   ', N'123123', 0)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [QuanLi]) VALUES (N'NV114   ', N'123123', 1)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [QuanLi]) VALUES (N'NV115   ', N'123123', 0)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [QuanLi]) VALUES (N'NV116   ', N'222222', 0)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [QuanLi]) VALUES (N'NV117   ', N'123123', 0)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [QuanLi]) VALUES (N'NV118   ', N'123123', 1)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [QuanLi]) VALUES (N'NV119   ', N'000000', 0)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [QuanLi]) VALUES (N'NV222   ', N'12345', 0)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [QuanLi]) VALUES (N'NV333   ', N'123123', 0)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [QuanLi]) VALUES (N'NV444   ', N'000000', 0)
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [QuanLi]) VALUES (N'NV555   ', N'000000', 0)
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [GiaBan], [SoLuong], [MoTa], [MaNSX], [MaLoaiT], [MaDV], [MaQG]) VALUES (N'T111    ', N'Vitamin', 50000, 48, N'NO', N'NSX112  ', N'LT111   ', N'DV111   ', N'QG111   ')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [GiaBan], [SoLuong], [MoTa], [MaNSX], [MaLoaiT], [MaDV], [MaQG]) VALUES (N'T112    ', N'Paracel Tamol', 60000, 48, N'NO', N'NSX112  ', N'LT111   ', N'DV111   ', N'QG111')
ALTER TABLE [dbo].[CTHoaDon]  WITH CHECK ADD FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([MaHD])
GO
ALTER TABLE [dbo].[CTHoaDon]  WITH CHECK ADD  CONSTRAINT [FK__CTHoaDon__MaThuo__30F848ED] FOREIGN KEY([MaThuoc])
REFERENCES [dbo].[Thuoc] ([MaThuoc])
GO
ALTER TABLE [dbo].[CTHoaDon] CHECK CONSTRAINT [FK__CTHoaDon__MaThuo__30F848ED]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK__HoaDon__MaKH__33D4B598] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK__HoaDon__MaKH__33D4B598]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK__HoaDon__MaNV__2D27B809] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK__HoaDon__MaNV__2D27B809]
GO
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD  CONSTRAINT [FK__KhachHang__MaLoa__35BCFE0A] FOREIGN KEY([MaLoaiKH])
REFERENCES [dbo].[LoaiKH] ([MaLoaiKH])
GO
ALTER TABLE [dbo].[KhachHang] CHECK CONSTRAINT [FK__KhachHang__MaLoa__35BCFE0A]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([TenTK])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
ALTER TABLE [dbo].[Thuoc]  WITH CHECK ADD  CONSTRAINT [FK__Thuoc__MaDV__38996AB5] FOREIGN KEY([MaDV])
REFERENCES [dbo].[DonVi] ([MaDV])
GO
ALTER TABLE [dbo].[Thuoc] CHECK CONSTRAINT [FK__Thuoc__MaDV__38996AB5]
GO
ALTER TABLE [dbo].[Thuoc]  WITH CHECK ADD  CONSTRAINT [FK__Thuoc__MaLoaiT__398D8EEE] FOREIGN KEY([MaLoaiT])
REFERENCES [dbo].[LoaiThuoc] ([MaLoaiT])
GO
ALTER TABLE [dbo].[Thuoc] CHECK CONSTRAINT [FK__Thuoc__MaLoaiT__398D8EEE]
GO
ALTER TABLE [dbo].[Thuoc]  WITH CHECK ADD  CONSTRAINT [FK__Thuoc__MaNSX__3A81B327] FOREIGN KEY([MaNSX])
REFERENCES [dbo].[NhaSanXuat] ([MaNSX])
GO
ALTER TABLE [dbo].[Thuoc] CHECK CONSTRAINT [FK__Thuoc__MaNSX__3A81B327]
GO

ALTER TABLE [dbo].[Thuoc]  WITH CHECK ADD  CONSTRAINT [FK_Thuoc_QuocGia] FOREIGN KEY([MaQG])
REFERENCES [dbo].[QuocGia] ([MaQG])
GO
ALTER TABLE [dbo].[Thuoc] CHECK CONSTRAINT [FK_Thuoc_QuocGia]
GO
USE [master]
GO
ALTER DATABASE [QuanLyQuayThuoc2] SET  READ_WRITE 
GO
