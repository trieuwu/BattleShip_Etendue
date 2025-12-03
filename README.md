# BattleShip Game

> **Bài tập giữa khóa Training JavaCore - D24 ProPTIT**

4h45p sáng 4/12/2025. HTT chưa được ngủ nên file README này được viết 100% bằng Gemini 3. Đừng đòi hỏi gì thêm!
---

## Mục lục
1. [Giới thiệu](#-giới-thiệu)
2. [Chức năng hoàn thiện](#-chức-năng-hoàn-thiện)
3. [Tính năng đang phát triển](#-tính-năng-đang-phát-triển-tiến-độ-36)
4. [Công nghệ sử dụng](#-công-nghệ-sử-dụng)
5. [Cài đặt & Hướng dẫn chơi](#-cài-đặt--hướng-dẫn-chơi)
6. [Tác giả](#-tác-giả)

---

## Giới thiệu
BattleShip là trò chơi đối kháng 1vs1. Trong dự án này, người chơi sẽ đấu với Máy (Bot). Nhiệm vụ của bạn là bố trí hạm đội của mình ẩn giấu trên bản đồ và đoán tọa độ hạm đội của đối phương để tiêu diệt.

## ✅ Chức năng hoàn thiện

### 1. Cơ chế Game (Gameplay)
- **Chế độ chơi:** Người đấu với Máy (PvE).
- **Hệ thống bản đồ:** Lưới toạ độ 10 x 10.
- **Hạm đội:** Gồm các loại tàu cơ bản (Patrol Boat, Destroyer, Submarine, Battleship).

### 2. Các tính năng chính
- [x] **Setup bản đồ:** Hỗ trợ tự động đặt tàu ngẫu nhiên (Random) và kiểm tra va chạm.
- [x] **Cơ chế bắn:** Nhập tọa độ tấn công, xử lý logic không cho bắn trùng vị trí cũ.
- [x] **Hiển thị trực quan:** Cập nhật trạng thái bản đồ (`~`: Nước, `X`: Trúng, `O`: Trượt) và ẩn tàu đối phương (Fog of War).
- [x] **Thông báo:** Báo số lượng tàu còn lại và thông báo thắng/thua.

---

## 🚧 Tính năng đang phát triển (Tiến độ: 36%)

### 1. Hệ thống Bot thông minh (AI)
Nâng cấp đối thủ máy với 3 cấp độ khó tùy chọn:
- **Dễ (Easy):** Bắn ngẫu nhiên hoàn toàn.
- **Khó (Hard):** Có thuật toán săn tìm (Hunt & Target), biết khoanh vùng khi bắn trúng.
- **Không thể thắng (Impossible):** Bot tối ưu hóa xác suất trúng cực cao, thử thách kỹ năng tối thượng của người chơi.

### 2. Kho đồ (Inventory) & Vật phẩm đặc biệt
Bổ sung tính năng sử dụng vật phẩm hỗ trợ trong trận đấu:
- **💣 Bom IT:** (Vũ khí công nghệ cao - Tính năng đang hoàn thiện logic sát thương).
- **☢️ Bom nguyên tử:** Vũ khí hủy diệt diện rộng, có khả năng quét sạch một vùng bản đồ lớn.

---

## 🛠 Công nghệ sử dụng
- **Ngôn ngữ:** Java (JDK 17).
- **IDE phát triển:** IntelliJ IDEA / VS Code.
- **Quản lý phiên bản:** Git & GitHub.

## 🎮 Cài đặt & Hướng dẫn chơi

### Bước 1: Clone dự án về máy
Mở Git Bash và chạy lệnh:
```bash
git clone [https://github.com/USERNAME-CUA-BAN/BattleShip-Project.git](https://github.com/USERNAME-CUA-BAN/BattleShip-Project.git)